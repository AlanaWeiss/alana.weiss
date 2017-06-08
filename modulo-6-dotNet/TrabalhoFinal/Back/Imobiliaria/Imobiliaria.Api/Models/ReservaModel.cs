using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Imobiliaria.Api.Models
{
    public class ReservaModel
    {
        public Cliente Cliente { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcional { get; set; }
    }
}