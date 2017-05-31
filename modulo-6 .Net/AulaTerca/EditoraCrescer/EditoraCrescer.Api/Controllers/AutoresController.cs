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
    public class AutoresController : ApiController
    {
        private AutoresRepositorio repositorio = new AutoresRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }

        //POST   api/Livros (apenas cria, não altera)
        public IHttpActionResult Post(Autor autor)
        {
            var criou = repositorio.Criar(autor);
            if (criou)
                return Ok();
            else
                return BadRequest("Nao foi possivel adicionar o autor :c");
        }

        //DELETE api/Livros/{id} (deleta pelo id)
        public IHttpActionResult Delete(int id)
        {
            var deletar = repositorio.Excluir(id);
            if (deletar)
                return Ok();
            else
                return BadRequest("Nao foi possivel deletar");
        }
    }
}
