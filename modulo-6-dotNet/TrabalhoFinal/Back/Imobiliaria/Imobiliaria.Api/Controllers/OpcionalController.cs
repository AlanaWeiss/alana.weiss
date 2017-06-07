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
    [RoutePrefix("api/opcional")]
    public class OpcionalController : ApiController
    {
        private readonly OpcionalRepositorio repositorio = new OpcionalRepositorio();

        [HttpPost]
        public IHttpActionResult CriarPacote(Opcional opcional)
        {
            return Ok(new { dados = repositorio.CriarOpcional(opcional) });
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult BuscarPacote(int id)
        {
            return Ok(new { dados = repositorio.BuscarOpcional(id) });
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
            return Ok(new { dados = repositorio.DeletarOpcional(id) });
        }
    }
}
