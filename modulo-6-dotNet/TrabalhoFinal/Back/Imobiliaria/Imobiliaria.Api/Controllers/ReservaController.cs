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
    [RoutePrefix("api/reserva")]
    public class ReservaController : ApiController
    {
        private readonly ReservaRepositorio repositorio = new ReservaRepositorio();

        [HttpPost]
        public IHttpActionResult CriarPacote(Reserva reserva)
        {
            return Ok(new { dados = repositorio.CriarReserva(reserva) });
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult BuscarPacote(int id)
        {
            return Ok(new { dados = repositorio.BuscarReserva(id) });
        }

        [HttpGet]
        [Route("{cpf}")]
        public IHttpActionResult BuscarPacote(string cpf)
        {
            return Ok(new { dados = repositorio.BuscarPorCpf(cpf) });
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
            return Ok(new { dados = repositorio.DeletarReserva(id) });
        }
    }
}
