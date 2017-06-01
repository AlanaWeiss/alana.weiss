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
    [RoutePrefix("api/revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(new { dados = repositorio.Obter() });
        }

        [Route("{id}")]
        public IHttpActionResult Get(int id)
        {
            return Ok(new { dados = repositorio.ObterPorId(id) });
        }

        public IHttpActionResult Post(Revisor revisor)
        {

            return Ok(new { dados = repositorio.Criar(revisor) });

        }

        [Route("{id}")]
        public IHttpActionResult Put(int id, Revisor revisor)
        {
            return Ok(new { dados = repositorio.Alterar(id, revisor) });
        }

        [Route("{id}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);

            return Ok(new { mensagens = "Deletado!" });
        }
    }
}
