using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public bool Criar(Autor autor)
        {
            try
            {
                contexto.Autores.Add(autor);
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
                var autorADeletar = contexto.Autores.FirstOrDefault(x => x.Id == id);
                contexto.Autores.Remove(autorADeletar);
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
