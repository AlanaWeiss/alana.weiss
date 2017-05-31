﻿using EditoraCrescer.Infraesturtura;
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
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }

        //POST   api/Livros (apenas cria, não altera)
        public IHttpActionResult Post(Livro livro)
        {
            var criou = repositorio.Criar(livro);
            if (criou)
                return Ok();
            else
                return BadRequest("Nao foi possivel adicionar o livro :c");
        }

        //DELETE api/Livros/{id} (deleta pelo id)
        public IHttpActionResult Delete(int id)
        {
            var deletar = repositorio.Excluir(id);
            if (deletar)
                return Ok();
            else
                return BadRequest("Nao foi possivel deletar");
        }
        
    }
}
