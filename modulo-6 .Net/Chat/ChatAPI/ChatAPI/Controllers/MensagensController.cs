using ChatAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatAPI.Controllers
{
    public class MensagensController : ApiController
    {
        public static List<Mensagem> mensagens { get; set; } = new List<Mensagem>();
        public static int idInterno { get; set; } = 0;
        private static object ObjetoLock = new Object();

        public List<Mensagem> Get(int? id = null)
        {

            return mensagens.Where(x =>
                                (id == null || id == x.Id)).ToList();

        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (ObjetoLock)
                {
                    mensagem.Id = ++idInterno;
                    mensagens.Add(mensagem);
                }
                //salva no banco de dados
                return Ok(mensagem);
            }


        }
    }
}
