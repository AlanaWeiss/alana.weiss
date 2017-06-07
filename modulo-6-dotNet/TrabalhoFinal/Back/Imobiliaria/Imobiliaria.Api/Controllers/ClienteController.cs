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
    [RoutePrefix("api/cliente")]
    public class ClienteController : ApiController
    {
        private readonly ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpPost]
        public IHttpActionResult CriarCliente(ClienteModel model)
        {
            var cliente = new Cliente(model.Id,model.Nome, model.Cpf, model.Endereco, model.Genero, model.DataNascimento);

            repositorio.CriarCliente(cliente);
                return Ok(new { dados = cliente });
        }

        [HttpGet]
        [Route("{cpf}")]
        public IHttpActionResult BuscarCpf(string cpf)
        {
            return Ok(new { dados = repositorio.BuscarCpf(cpf) });
        }

        [HttpGet]
        public IHttpActionResult BuscarTodosClientes()
        {
            return Ok(new { dados = repositorio.BuscarTodos() });
        }
        
    }
}
