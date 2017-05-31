using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio //: IDisposable
    {
        private Contexto contexto = new Contexto();
        private AutoresRepositorio autorRepositorio = new AutoresRepositorio();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();

        public List<Livro> Listar()
        {
            var livros = contexto.Livros.ToList();

            livros.ForEach(l => {
                l.Autor = autorRepositorio.Obter(l.IdAutor);
                l.Revisor = revisorRepositorio.ObterPorId(l.IdRevisor);
            });

            return livros;
        }

        public Livro ObterPorId(int isbn)
        {
            var livro = contexto.Livros.Where(l => l.Isbn == isbn).FirstOrDefault();
            livro.Autor = autorRepositorio.Obter(livro.IdAutor);
            livro.Revisor = revisorRepositorio.ObterPorId(livro.IdRevisor);
            return livro;
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            var livros = contexto.Livros.Where(l => l.Genero.Contains(genero)).ToList();
            livros.ForEach(l => {
                l.Autor = autorRepositorio.Obter(l.IdAutor);
                l.Revisor = revisorRepositorio.ObterPorId(l.IdRevisor);
            });
            return livros;
        }

        public Livro Alterar(int isbn)
        {
            
            var livroAlterar = contexto.Livros.Where(l => l.Isbn == isbn).FirstOrDefault();

            livroAlterar.Titulo = "alterado";

            contexto.Entry(livroAlterar).State = EntityState.Modified;
            contexto.SaveChanges();
            return livroAlterar;
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Deletar(int isbn)
        {
            contexto.Livros.Remove(contexto.Livros.Where(l => l.Isbn == isbn).FirstOrDefault());
            contexto.SaveChanges();
        }

        //public void Dispose()
        //{
        //    contexto.Dispose();
        //}
    }
}
