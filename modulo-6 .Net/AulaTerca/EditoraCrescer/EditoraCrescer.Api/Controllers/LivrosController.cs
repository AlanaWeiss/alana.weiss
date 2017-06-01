using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/livros")]

    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();
        
        public IHttpActionResult Get()
        {
            //return Ok(repositorio.Listar());
            return Ok(repositorio.ListarResumo());
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            return Ok( new { dados = repositorio.ObterPorId(isbn) });
        }

        [HttpGet]
        [Route("Lancamentos")]
        public IHttpActionResult GetLancamentos()
        {
            return Ok(new { dados = repositorio.ObterPorLancamento() });
        }

        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            //return Ok(repositorio.ObterPorGenero(genero));
            return Ok(new { dados = repositorio.ObterPorGeneroResumo(genero) });
        }

        public IHttpActionResult Post(Livro livro)
        {
            return Ok(new { dados = repositorio.Criar(livro) });
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            ;
            return Ok( new { mensagens = "Deletado!" });
        }

        //protected override void Dispose(bool disposing)
        //{
        //    repositorio.Dispose();
        //    base.Dispose(disposing);
        //}

    }
}
