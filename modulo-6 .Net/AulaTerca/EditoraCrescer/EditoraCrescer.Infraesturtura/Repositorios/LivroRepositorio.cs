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

            livros.ForEach(l =>
            {
                l.Autor = autorRepositorio.Obter(l.IdAutor);
                l.Revisor = revisorRepositorio.ObterPorId(l.IdRevisor);
            });

            return livros;
        }

        public dynamic ListarResumo()
        {
            return contexto.Livros.Select(l => new
            {
                Isbn = l.Isbn,
                Titulo = l.Titulo,
                Capa = l.Capa,
                NomeAutor = l.Autor.Nome,
                Genero = l.Genero,
                Publicacao = l.DataPublicacao
            });
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
            livros.ForEach(l =>
            {
                l.Autor = autorRepositorio.Obter(l.IdAutor);
                l.Revisor = revisorRepositorio.ObterPorId(l.IdRevisor);
            });
            return livros;
        }
        public dynamic ObterPorGeneroResumo(string genero)
        {
            var livros = contexto.Livros.Where(l => l.Genero.Contains(genero)).Select(l => new
            {
                Isbn = l.Isbn,
                Titulo = l.Titulo,
                Capa = l.Capa,
                NomeAutor = l.Autor.Nome,
                Genero = l.Genero
            }).ToList();
            
            return livros;
        }

    public Livro Alterar(int isbn, Livro livro)
    {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return ObterPorId(isbn);
        }

    public Livro Criar(Livro livro)
    {
        contexto.Livros.Add(livro);
        contexto.SaveChanges();

        return livro;
    }

    public void Deletar(int isbn)
    {
        contexto.Livros.Remove(contexto.Livros.Where(l => l.Isbn == isbn).FirstOrDefault());
        contexto.SaveChanges();
        
    }

    public dynamic ObterPorLancamento()
        {
            var data = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(l => (l.DataPublicacao > data))
                .Select(l => new {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero
                })
                .ToList();
        }

    //public void Dispose()
    //{
    //    contexto.Dispose();
    //}
}
}
