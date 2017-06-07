using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Imobiliaria.Api.Controllers
{
    [RoutePrefix("api/pacote")]
    public class PacoteController : ApiController
    {
        private readonly PacoteRepositorio repositorio = new PacoteRepositorio();

        [HttpPost]
        public IHttpActionResult CriarPacote(Pacote produto)
        {
            return Ok(new { dados = repositorio.CriarPacote(produto) });
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult BuscarPacote(int id)
        {
            return Ok(new { dados = repositorio.BuscarPacote(id) });
        }

        [HttpGet]
        public IHttpActionResult BuscarTodosPacotes()
        {
            return Ok(new { dados = repositorio.BuscarTodos() });
        }

        [HttpDelete]
        [Route("{id}")]
        public IHttpActionResult DeletarProduto(int id)
        {
            return Ok(new { dados = repositorio.DeletarPacote(id) });
        }
    }
}
