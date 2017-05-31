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
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        //POST   api/Livros (apenas cria, não altera)
        public IHttpActionResult Post(Revisor revisor)
        {
            var criou = repositorio.Criar(revisor);
            if (criou)
                return Ok();
            else
                return BadRequest("Nao foi possivel adicionar o revisor :c");
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
