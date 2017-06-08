using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        private Contexto contexto = new Contexto();
        public Reserva CriarReserva(Reserva reserva)
        {
            DiminuirQuantidade(reserva);
            reserva.ValorTotal = GerarValor(reserva, reserva.DataDevolucaoPrevista);
            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
            return reserva;
        }

        private void DiminuirQuantidade(Reserva reserva)
        {
           int produtoId = reserva.Produto.Id;
            Produto produto = contexto.Produtos.Where(x=> x.Id == produtoId).FirstOrDefault();
            produto.Quantidade--;
            contexto.SaveChanges();

            List<Opcional> opcionais = new List<Opcional>();

            foreach (var opcional in reserva.Opcional)
            {
                opcionais.Add(contexto.Opcionais.Where(x => x.Id == opcional.Id).FirstOrDefault());
            }
            foreach (var opcional in opcionais)
            {
                opcional.Quantidade--;
            }
            contexto.SaveChanges();
        }

        private Decimal GerarValor(Reserva reserva, DateTime devolucao)
        {
            int diasReserva= (devolucao.Date - reserva.DataPedido.Date).Days;
            Produto produto = reserva.Produto;

            Pacote pacote = reserva.Pacote;

            var precoPacote = pacote == null ? 0 : pacote.Preco;

            var precoOpcionais = 0;

            List<Opcional> opcionais = new List<Opcional>();
            if (reserva.Opcional != null)
            {
                foreach (var opcional in reserva.Opcional)
                {
                    opcionais.Add(contexto.Opcionais.Where(x => x.Id == opcional.Id).FirstOrDefault());
                }

                if (opcionais.Count > 0)
                    precoOpcionais = opcionais.Sum(x => x.Preco);
            }

            return ( precoPacote + precoOpcionais) * diasReserva;
        }
    }
}
