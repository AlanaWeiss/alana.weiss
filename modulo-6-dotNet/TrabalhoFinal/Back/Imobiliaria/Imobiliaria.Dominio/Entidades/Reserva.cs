using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Dominio.Entidades
{
    public class Reserva
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public Produto Produto { get; set; }
         public Pacote Pacote { get; set; }
         public List<Opcional> Opcional { get; set; }
         public DateTime DataPedido { get; set; }
         public DateTime DataDevolucaoPrevista { get; set; }
         public DateTime? DataDevolucaoReal { get; set; }
         public decimal ValorTotal { get; set; }
         public decimal ValorTotalReal { get; set; }
    }
}
