using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public Autor Obter(int id)
        {
            //var autoresContador = contexto.Autores.Where(a => a.Id == id).Count();
            //if (autoresContador < 1)
            //    return null;

            return contexto.Autores.Where(a => a.Id == id).FirstOrDefault(); ;
        }

        public List<Livro> ObterOsLivros(int id)
        {
            return contexto.Livros.Where(l => l.IdAutor == id).ToList();
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            contexto.Autores.Remove(contexto.Autores.Where(l => l.Id == id).FirstOrDefault());
            contexto.SaveChanges();
        }

        public Autor Alterar(int id)
        {
            var autorAlterar = contexto.Autores.Where(l => l.Id == id).FirstOrDefault();

            autorAlterar.Nome = "alterado";

            contexto.Entry(autorAlterar).State = EntityState.Modified;
            contexto.SaveChanges();
            return autorAlterar;
        }

    }

    //select passando para um new object. pro autor x.Autor.Nome
}
