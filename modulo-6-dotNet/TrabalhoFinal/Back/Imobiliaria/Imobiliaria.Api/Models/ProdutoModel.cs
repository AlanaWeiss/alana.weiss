using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Imobiliaria.Api.Models
{
    public class ProdutoModel
    {
        public int Id { get; set; }
        public string Imovel { get; set; }
        public decimal Preco { get; set; }
        public int Quantidade { get; set; }
    }
}