using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Imobiliaria.Dominio.Entidades;
using System.Data.Entity;

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
        
        public Reserva CriarOrcamento(Reserva reserva)
        {
            DiminuirQuantidade(reserva);
            reserva.ValorTotal = GerarValor(reserva, reserva.DataDevolucaoPrevista);
            //contexto.Reservas.Add(reserva);
            //contexto.SaveChanges();
            return reserva;
        }

        public List<Reserva> Reservas()
        {
            return contexto.Reservas.Include(X => X.Produto).Include(X => X.Pacote).Include(X => X.Cliente).Include(X => X.Opcional).ToList();
        }

        public Reserva DevolverReserva(int id)
        {
            Reserva reserva = contexto.Reservas
                .Include(X => X.Produto)
                .Include(X => X.Pacote)
                .Include(X => X.Cliente)
                .Include(X => X.Opcional)
                .Where(x => x.Id == id)
                .FirstOrDefault();
            
            
            bool atrasou = DateTime.Now.Date > reserva.DataDevolucaoPrevista.Date;

            reserva.DataDevolucaoReal = DateTime.Now;
            var devolucao = DateTime.Now;

            if (atrasou)
                reserva.ValorTotalReal = GerarValor(reserva, devolucao);
            else
                reserva.ValorTotalReal = reserva.ValorTotal;

            AumentarQuantidade(reserva);

            contexto.Entry(reserva).State = EntityState.Modified;
            contexto.SaveChanges();

            return reserva;
        }

        private void DiminuirQuantidade(Reserva reserva)
        {
            int produtoId = reserva.Produto.Id;
            Produto produto = contexto.Produtos.Where(x => x.Id == produtoId).FirstOrDefault();
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

        private void AumentarQuantidade(Reserva reserva)
        {
            Produto produto = contexto.Produtos.Where(x => x.Id == reserva.Produto.Id).FirstOrDefault();
            produto.Quantidade++;
            contexto.SaveChanges();

            List<Opcional> opcionais = new List<Opcional>();

            foreach (var opcional in reserva.Opcional)
            {
                opcionais.Add(contexto.Opcionais.Where(x => x.Id == opcional.Id).FirstOrDefault());
            }
            foreach (var opcional in opcionais)
            {
                opcional.Quantidade++;
            }
            contexto.SaveChanges();
        }

        private Decimal GerarValor(Reserva reserva, DateTime devolucao)
        {
            int diasReserva = (devolucao.Date - reserva.DataPedido.Date).Days;
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

            return (precoPacote + precoOpcionais) * diasReserva;
        }

        public bool VerSeEhPossivelCriar(Reserva reserva)
        {
            Produto produto = contexto.Produtos.Where(x => x.Id == reserva.Produto.Id).FirstOrDefault();

            if (produto.Quantidade < 0)
                return false;


            if (reserva.Opcional.Count > 0)
            {
                // verifica se tem opcionais em estoque
                foreach (var opcional in reserva.Opcional)
                {
                    Opcional aux = contexto.Opcionais.Where(x => x.Id == opcional.Id).FirstOrDefault();

                    if (aux == null)
                        return false;

                    if (aux.Quantidade <= 0)
                        return false;

                }
            }
            return true;
        }
    }
}
