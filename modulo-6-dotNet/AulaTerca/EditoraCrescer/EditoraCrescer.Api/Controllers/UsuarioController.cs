using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ApiController
    {
        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        private HttpResponseMessage resposta(bool sucesso, dynamic mensagens)
        {
            if (sucesso)
                return Request.CreateResponse(HttpStatusCode.OK, new { mensagens = mensagens });

            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage cadastrarUsuario(Usuario usuario)
        {
            if (repositorio.buscar(usuario.Email) == null)
            {
                if (usuario.Validar())
                    repositorio.cadastrar(usuario);

                else
                    return resposta(false, usuario.Mensagens);
            }
            else
                return resposta(false, "Ops.. Esse usuário já existe. Tente novamente");

            return resposta(true, "Usuario cadastrado com sucesso!");

        }

        [HttpGet]
        public IHttpActionResult buscar(string email)
        {
            var usuario = repositorio.buscar(email);
            return Ok(new { dados = usuario });
        }

    }
}
