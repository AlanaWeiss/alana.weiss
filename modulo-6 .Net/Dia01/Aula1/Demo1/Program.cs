using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Pessoa pessoa = new Pessoa();
            //pessoa.Id = null;
            //pessoa.Nascimento = new DateTime(1998, 06, 27);
            //pessoa.Nome = $"Alana Weiss {pessoa.Id}";


            //if (pessoa.Id.HasValue)
            //{
            //    Console.WriteLine("Nao tem valor");
            //}
            //else
            //{
            //    Console.WriteLine(pessoa.Id.Value);
            //}

            //Console.WriteLine(pessoa.Nome);
            //Console.ReadKey();

            Console.WriteLine("Informe o peso");
            var entradaPeso = Console.ReadLine();

            Console.WriteLine("Informe a altura");
            var entradaAltura = Console.ReadLine();

            var peso = 0D; // pode-se declarar um double assim 

            if (!double.TryParse(entradaPeso, out peso))
                Console.WriteLine("Entrada inválidda");

            var altura = double.Parse(entradaAltura);

            var calcularIMC = new CalculoIMC(altura, peso);
            var imc = calcularIMC.CalcularIMC();

            Console.WriteLine($"Seu IMC é:  {imc}");
            Console.ReadKey();
        }
    }
}
