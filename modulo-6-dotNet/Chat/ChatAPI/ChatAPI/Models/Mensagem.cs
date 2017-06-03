using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatAPI.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string Texto { get; set; }
        public Usuario Usuario { get; set; }
        public readonly DateTime EnviadoEm = DateTime.Now;
    }
}