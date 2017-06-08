using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public string Imovel { get;  set; }
        public int Preco { get;  set; }
        public int Quantidade { get;  set; }

        
    }

}
