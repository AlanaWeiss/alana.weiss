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
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutoresRepositorio repositorio = new AutoresRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }

        [Route("{id}")]
        public IHttpActionResult Get(int id)
        {
            return Ok(repositorio.Obter(id));
        }

        //[Route("{id}/Livros")]
        //public IHttpActionResult Get(int idAutor)
        //{
        //    return Ok(repositorio.ObterOsLivros(idAutor));
        //}

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        [Route("{id}")]
        public IHttpActionResult Put(int id)
        {
            repositorio.Alterar(id);
            return Ok();
        }

        [Route("{id}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
