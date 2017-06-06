using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Dominio.Entidades
{
    public class Cliente
    {

        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Cpf { get; private set; }
        public string Endereco { get; private set; }
        public string Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }

        protected Cliente() { } //EF :(

        public Cliente(int id, string nome, string cpf, string endereco, string genero, DateTime dataNascimento)
        {
            Id = id;
            Nome = nome;
            Cpf = cpf;
            Endereco = endereco;
            Genero = genero;
            DataNascimento = dataNascimento;
        }
    }
}
