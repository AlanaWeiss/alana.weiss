using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio1
{
    class Program
    {
        static void Main(string[] args)
        {
            //var entradas = new int[] { };

            //Console.WriteLine("Digite numeros inteiros");
            //while (KeyEvent.KEY_PRESSED != 13)
            //{
            //    var numerosDigitados = Console.ReadLine();

            //    var nrEntradas = entradas.Length;
            //    var aux = new int[nrEntradas + 1];

            //    for (int i = 0; i < nrEntradas; i++)
            //    {
            //           aux[i] = entradas[i];
            //    }
            //    aux[nrEntradas] = int.Parse(numerosDigitados);
            //    entradas = aux;
            //}

            List<int> entradas = new List<int>();
            Console.WriteLine("Digite numeros inteiros");
            var continua = true;
            while (continua)
            {
                var linhaEntrada = Console.ReadLine();
                if (linhaEntrada == "exit")
                {
                    break;
                }
                entradas.Add(int.Parse(linhaEntrada));
            }
            Console.WriteLine("Valores digitados:");
            foreach (var item in entradas)
            {
                Console.WriteLine(item);
            }
            Console.ReadKey();
        }
    }
}
