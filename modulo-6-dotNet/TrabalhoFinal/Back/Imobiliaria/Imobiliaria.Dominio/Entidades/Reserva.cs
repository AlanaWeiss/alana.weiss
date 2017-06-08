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

        public Reserva()
        { }

        public Reserva(Cliente cliente, Produto produto, Pacote pacote, List<Opcional> opcional)
        {
            Cliente = cliente;
            Produto = produto;
            Pacote = pacote;
            Opcional = opcional;
            DataPedido = DateTime.Now;
            Id = 0;
            DataDevolucaoPrevista = DateTime.Now.AddDays(1);
            ValorTotal = 0;
            ValorTotalReal = 0;
        }
    }
}
