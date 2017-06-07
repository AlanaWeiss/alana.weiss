using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        private Contexto contexto = new Contexto();
        private ClienteRepositorio clienteRepo = new ClienteRepositorio();
        private PacoteRepositorio pacoreRepo = new PacoteRepositorio();
        private ProdutoRepositorio ProdutoRepo = new ProdutoRepositorio();
        private OpcionalRepositorio OpcionalRepo = new OpcionalRepositorio();

        public Reserva CriarReserva(Reserva reserva)
        {
            contexto.Reservas.Add(reserva);
            contexto.SaveChanges();
            return reserva;

        }

        public Reserva BuscarReserva(int id)
        {
            return contexto.Reservas.FirstOrDefault(x => x.Id == id);

        }

        public List<Reserva> BuscarTodos()
        {
            var reservas = contexto.Reservas.ToList();
            reservas.ForEach(l =>
            {
                l.Cliente = clienteRepo.BuscarId(l.IdCliente);
                l.Produto = ProdutoRepo.BuscarProduto(l.IdProduto);
                l.Pacote = pacoreRepo.BuscarPacote(l.IdPacote);
            });

            return reservas;
        }
        public List<Reserva> BuscarPorCpf(string cpf)
        {
            return contexto.Reservas.Where(x => x.Cliente.Cpf == cpf)
                .Include(X => X.Cliente)
                .Include(x => x.Produto)
                .Include(X => X.Pacote)
                .Include(X => X.Opcional)
                .ToList();
        }

        public Reserva DeletarReserva(int id)
        {
            Reserva pacote = contexto.Reservas.FirstOrDefault(x => x.Id == id);

            contexto.Reservas.Remove(pacote);
            contexto.SaveChanges();
            return pacote;
        }
    }
}
