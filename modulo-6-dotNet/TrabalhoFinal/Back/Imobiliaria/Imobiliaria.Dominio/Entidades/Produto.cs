using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; private set; }
        public string Imovel { get; private set; }
        public decimal Preco { get; private set; }
        public int Quantidade { get; private set; }

        public Produto()
        {}

        public Produto(int id, string imovel, decimal preco, int quantidade)
        {
            Id = id;
            Imovel = imovel;
            Preco = preco;
            Quantidade = quantidade;
        }
    }

}
