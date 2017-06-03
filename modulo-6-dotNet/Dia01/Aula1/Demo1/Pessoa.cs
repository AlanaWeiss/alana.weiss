using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    public class Pessoa
    {

        public readonly double PIreadonly;
        public const double PI = 3.14;

        public Pessoa()
        {
            PIreadonly = 3.14;
        }

        public string Nome { get; set; }
        public int? Id { get; set; }
        public DateTime Nascimento{ get; set; }
    }
}
