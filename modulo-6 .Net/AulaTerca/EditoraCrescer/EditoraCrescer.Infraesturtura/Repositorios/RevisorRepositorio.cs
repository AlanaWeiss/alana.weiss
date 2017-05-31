using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisor.ToList();
        }

        public bool Criar(Revisor revisor)
        {
            try
            {
                contexto.Autores.Add(revisor);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Excluir(int id)
        {
            try
            {
                var revisorADeletar = contexto.Revisor.FirstOrDefault(x => x.Id == id);
                contexto.Autores.Remove(revisorADeletar);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }
    }
}
