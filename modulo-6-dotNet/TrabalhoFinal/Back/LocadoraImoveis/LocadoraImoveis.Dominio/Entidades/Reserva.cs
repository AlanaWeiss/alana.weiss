using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraImoveis.Dominio.Entidades
{
    public class Reserva
    {
        public int Id { get; set; }
        public List<int> IdItens { get; set; }
        public List<Produto> Itens { get; set; }
        public int PrecoReserva { get; set; }
        public DateTime DataDevolucaoPrevista { get; set; }
        public DateTime? DataDevolucaoReal { get; set; }
        public DateTime DataRetirada = new DateTime();
    }
}
