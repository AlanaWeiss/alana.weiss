using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ClienteRepositorio
    {
        private Contexto contexto = new Contexto();

        public void CriarCliente(Cliente cliente)
        {

            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();

        }

        public Cliente BuscarCpf(string cpf)
        {
            return contexto.Clientes.Where(x => x.Cpf.Contains(cpf)).FirstOrDefault();
        }

        public List<Cliente> BuscarTodos()
        {
            return contexto.Clientes.ToList();
        }
    }
}
