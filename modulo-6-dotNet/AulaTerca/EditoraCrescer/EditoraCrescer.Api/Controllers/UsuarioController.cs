using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using EditoraCrescer.Api.Models;
using EditoraCrescer.Api.App_Start;
using System.Threading;

namespace EditoraCrescer.Api.Controllers
{
    //[AllowAnonymous]
    //[RoutePrefix("api/acessos")]
    //public class UsuarioController : ApiController
    //{
    //    private UsuarioRepositorio repositorio = new UsuarioRepositorio();

    //    private HttpResponseMessage resposta(bool sucesso, dynamic mensagens)
    //    {
    //        if (sucesso)
    //            return Request.CreateResponse(HttpStatusCode.OK, new { mensagens = mensagens });

    //        return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = mensagens });
    //    }

    //    [HttpPost, Route("registrar")]
    //    public HttpResponseMessage cadastrarUsuario(Usuario usuario)
    //    {
    //        if (repositorio.buscar(usuario.Email) == null)
    //        {
    //            if (usuario.Validar())
    //                repositorio.cadastrar(usuario);

    //            else
    //                return resposta(false, usuario.Mensagens);
    //        }
    //        else
    //            return resposta(false, "Ops.. Esse usuário já existe. Tente novamente");

    //        return resposta(true, "Usuario cadastrado com sucesso!");

    //    }

    //    [HttpGet]
    //    [Route("{email}")]
    //    public IHttpActionResult Get(string email)
    //    {
    //        var usuario = repositorio.buscar(email);
    //        return Ok(new { dados = usuario });
    //    }

    //}

    [AllowAnonymous]
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
        [BasicAuthorization]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, "Usuário não encontrado.");

            return Request.CreateResponse(HttpStatusCode.OK, new { usuario.Nome, usuario.Permissoes, usuario.Email });
        }
    }
}
