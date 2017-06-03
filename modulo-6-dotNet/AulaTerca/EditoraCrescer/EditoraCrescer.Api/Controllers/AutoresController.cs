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
    [AllowAnonymous]
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutoresRepositorio repositorio = new AutoresRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        [Route("{id}")]
        public IHttpActionResult Get(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }

        [HttpGet]
        [Route("{id}/livros")]
        public IHttpActionResult GetLivros(int id)
        {
            return Ok(new { dados = repositorio.ObterLivros(id) });
        }

        public IHttpActionResult Post(Autor autor)
        {

            return Ok(new { dados = repositorio.Criar(autor) });
        }

        [Route("{id}")]
        public IHttpActionResult Put(int id, Autor autor)
        {
            return Ok(new { dados = repositorio.Alterar(id, autor) });
        }

        [Route("{id}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok(new { mensagens = "Deletado!" });
        }
    }
}
