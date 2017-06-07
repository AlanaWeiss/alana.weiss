using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class OpcionalRepositorio
    {
        private Contexto contexto = new Contexto();

        public Opcional CriarOpcional(Opcional opcional)
        {
            contexto.Opcionais.Add(opcional);
            contexto.SaveChanges();
            return opcional;

        }

        public Opcional BuscarOpcional(int? id)
        {
            return contexto.Opcionais.FirstOrDefault(x => x.Id == id);
        }

        public List<Opcional> BuscarTodos()
        {
            return contexto.Opcionais.ToList();
        }

        public Opcional DeletarOpcional(int id)
        {
            Opcional opcional = contexto.Opcionais.FirstOrDefault(x => x.Id == id);

            contexto.Opcionais.Remove(opcional);
            contexto.SaveChanges();
            return opcional;
        }
    }
}
