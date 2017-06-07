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
    [RoutePrefix("api/produto")]
    public class ProdutoController : ApiController
    {
        private readonly ProdutoRepositorio repositorio = new ProdutoRepositorio();

        [HttpPost]
        public IHttpActionResult CriarProduto(Produto produto)
        {
            return Ok(new { dados = repositorio.CriarProduto(produto)});
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult BuscarProduto(int id)
        {
            return Ok(new { dados = repositorio.BuscarProduto(id) });
        }

        [HttpGet]
        public IHttpActionResult BuscarTodosProdutos()
        {
            return Ok(new { dados = repositorio.BuscarTodos() });
        }

        [HttpDelete]
        [Route("{id}")]
        public IHttpActionResult DeletarProduto(int id)
        {
            return Ok(new { dados = repositorio.DeletarProduto(id) });
        }
    }
}
