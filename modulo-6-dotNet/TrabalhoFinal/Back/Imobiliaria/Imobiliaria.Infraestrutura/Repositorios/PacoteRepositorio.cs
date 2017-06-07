using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class PacoteRepositorio
    {
        private Contexto contexto = new Contexto();

        public Pacote CriarPacote(Pacote pacote)
        {
            contexto.Pacotes.Add(pacote);
            contexto.SaveChanges();
            return pacote;

        }

        public Pacote BuscarPacote(int id)
        {
            return contexto.Pacotes.FirstOrDefault(x => x.Id == id);
        }

        public List<Pacote> BuscarTodos()
        {
            return contexto.Pacotes.ToList();
        }

        public Pacote DeletarPacote(int id)
        {
            Pacote pacote = contexto.Pacotes.FirstOrDefault(x => x.Id == id);

            contexto.Pacotes.Remove(pacote);
            contexto.SaveChanges();
            return pacote;
        }

    }
}
