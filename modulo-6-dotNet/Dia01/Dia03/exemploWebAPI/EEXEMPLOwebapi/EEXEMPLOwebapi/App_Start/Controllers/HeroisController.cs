using EEXEMPLOwebapi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;


namespace ExemploWebAPI.Controllers
{
    public class HeroisController : ApiController
    {
        public static List<Heroi> herois { get; set; } = new List<Heroi>();
        public static int idInterno { get; set; } = 0;
        private static object ObjetoLock = new Object();

        public List<Heroi> Get(string nome = null, int? id= null)
        {           

            return herois.Where(x =>
                                (id == null || id == x.Id) &&
                                (nome == null || x.Nome == nome)
                            ).ToList();

        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }
            else
            {
                lock (ObjetoLock)
                {
                    heroi.Id = ++idInterno;
                    herois.Add(heroi);
                }
                //salva no banco de dados
                return Ok(heroi);
            }
            

        }
    }
}
