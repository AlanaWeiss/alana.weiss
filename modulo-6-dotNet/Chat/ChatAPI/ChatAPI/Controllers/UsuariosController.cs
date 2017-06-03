using ChatAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatAPI.Controllers
{
    public class UsuariosController : ApiController
    {
        public static List<Usuario> usuarios { get; set; } = new List<Usuario>();
        public static int idInterno { get; set; } = 0;
        private static object ObjetoLock = new Object();

        public List<Usuario> Get(int? id = null)
        {

            return usuarios.Where(x =>
                                (id == null || id == x.Id)).ToList();

        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (ObjetoLock)
                {
                    usuario.Id = ++idInterno;
                    usuarios.Add(usuario);
                }
                //salva no banco de dados
                return Ok(usuario);
            }


        }
    }
}
