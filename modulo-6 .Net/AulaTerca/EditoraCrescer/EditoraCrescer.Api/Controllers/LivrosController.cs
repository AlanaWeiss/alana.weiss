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

        //[HttpGet]
        public IHttpActionResult Get(int quantidadePular, int quantidadeTrazer)
        {
            return Ok(new { dados = repositorio.ListarResumo(quantidadePular, quantidadeTrazer) });
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

        [HttpPut]
        [Route("{isbn}")]
        public HttpResponseMessage EditarLivro(int isbn, Livro livro)
        {
            var mensagens = new List<string>();
            if (isbn != livro.Isbn)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - ISBNs diferentes" } });

            if (!repositorio.VerificaExistenciaLivro(isbn))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Livro não cadastrado" } });

            repositorio.Editar(livro);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = livro });
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
