using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Imobiliaria.Api.Models
{
    public class ClienteModel
    {
        public int Id { get; set; }
        public string Nome { get;set; }
        public string Cpf { get; set; }
        public string Endereco { get; set; }
        public string Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}