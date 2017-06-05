using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraImoveis.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string CPF { get; set; }
        public int IdEndereco { get; set; }
        public Endereco Endereco { get; set; }
        public string Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}
