using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Imobiliaria.Api.Controllers
{
        [RoutePrefix("api/acessos")]
        public class UsuarioController : ApiController
        {
            readonly UsuarioRepositorio _usuarioRepositorio;

            public UsuarioController()
            {
                _usuarioRepositorio = new UsuarioRepositorio();
            }

            [HttpPost, Route("registrar")]
            public HttpResponseMessage Registrar(Usuario usuario)
            {
                if (_usuarioRepositorio.Obter(usuario.Email) == null)
                {

                    if (usuario.Validar())
                    {
                        _usuarioRepositorio.Criar(usuario);
                    }
                    else
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, new { usuario.Mensagens });
                    }
                }
                else
                {
                    return Request.CreateResponse(HttpStatusCode.BadRequest, "Usuário já existe.");
                }
                return Request.CreateResponse(HttpStatusCode.OK);
            }

            //[HttpPost, Route("resetarsenha")]
            //public HttpResponseMessage ResetarSenha(string email)
            //{
            //    var usuario = _usuarioRepositorio.Obter(email);
            //    if (usuario == null)
            //        return Request.CreateResponse(HttpStatusCode.BadRequest, "Usuário não encontrado." );

            //    var novaSenha = usuario.ResetarSenha();

            //    if (usuario.Validar())
            //    {
            //        _usuarioRepositorio.Alterar(usuario);
            //        // EmailService.Enviar(usuario.Email, "Crescer 2017-1", $"Olá! sua senha foi alterada para: {novaSenha}");
            //    }
            //    else
            //        return Request.CreateResponse(HttpStatusCode.BadRequest, new { usuario.Mensagens });

            //    return Request.CreateResponse(HttpStatusCode.OK);
            //}

            // Exige que o usuário se autentique

            [HttpGet, Route("usuario")]
            [BasicAuthorization(Roles = "Revisor")]
            public IHttpActionResult Obter()
            {
                var usuarioDaSessao = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

                if (usuarioDaSessao == null)
                {
                    return BadRequest("Usuario não encontrado");
                }
                var usuario = new { Nome = usuarioDaSessao.Nome, Email = usuarioDaSessao.Email, Permissoes = usuarioDaSessao.Permissoes };
                return Ok(new { dados = usuario });
            }
        }
}
