using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    {
        private Contexto contexto = new Contexto();

        public Produto CriarProduto(Produto produto)
        {
            contexto.Produtos.Add(produto);
            contexto.SaveChanges();
            return produto;

        }

        public Produto BuscarProduto(int id)
        {
            return contexto.Produtos.FirstOrDefault(x => x.Id == id);
        }

        public List<Produto> BuscarTodos()
        {
            return contexto.Produtos.ToList();
        }

        public Produto DeletarProduto(int id)
        {
            Produto produto = contexto.Produtos.FirstOrDefault(x => x.Id == id);

            contexto.Produtos.Remove(produto);
            contexto.SaveChanges();
            return produto;
        }

    }
}
