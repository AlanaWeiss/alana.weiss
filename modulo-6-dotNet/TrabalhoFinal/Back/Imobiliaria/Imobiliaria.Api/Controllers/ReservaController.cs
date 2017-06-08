using Imobiliaria.Api.App_Start;
using Imobiliaria.Api.Models;
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
    [BasicAuthorization]
    public class ReservaController : ApiController
    {
        private readonly ReservaRepositorio repositorio = new ReservaRepositorio();
        private ClienteRepositorio clienteRepo = new ClienteRepositorio();
        private ProdutoRepositorio produtoRepo = new ProdutoRepositorio();
        private PacoteRepositorio pacoteRepo = new PacoteRepositorio();
        private OpcionalRepositorio opcionalRepo = new OpcionalRepositorio();

        [HttpPost]
        public IHttpActionResult CriarReserva(ReservaModel model)
        {
            Produto produto = produtoRepo.BuscarProduto(model.Produto.Id);
            Pacote pacote = pacoteRepo.BuscarPacote(model.Pacote.Id);
            Cliente cliente = clienteRepo.BuscarId(model.Cliente.Id);

            var opcional = new List<Opcional>();
            model.Opcional.ForEach(x => opcional.Add(opcionalRepo.BuscarOpcional(x.Id)));

            var reserva = new Reserva(cliente, produto, pacote, opcional);

            bool possivelCriar = repositorio.VerSeEhPossivelCriar(reserva);
            if (possivelCriar)
            {
                repositorio.CriarReserva(reserva);
                return Ok(new { dados = reserva });
            }

            return BadRequest("Ops.. temos um problema");
        }

        [HttpPost]
        [Route("devolver/{id}")]
        public IHttpActionResult DevolverProduto(int id)
        {
            var reserva = repositorio.DevolverReserva(id);
            return Ok(new { dados = reserva });
        }

        [HttpGet]
        public IHttpActionResult BuscarReservas()
        {
            return Ok(new { dados = repositorio.Reservas() });
        
        }
    }
}
