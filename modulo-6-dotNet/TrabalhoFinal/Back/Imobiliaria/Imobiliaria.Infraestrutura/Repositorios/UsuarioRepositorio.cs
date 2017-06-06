using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        //private Contexto contexto = new Contexto();

        //public Usuario buscar(string email)
        //{
        //    return contexto.Usuarios.Where(user => user.Email == email).FirstOrDefault();
        //}

        //public Usuario cadastrar(Usuario usuario)
        //{
        //    contexto.Usuarios.Add(usuario);
        //    contexto.SaveChanges();

        //    return usuario;
        //}

        //public Usuario alterar()
        //{
        //    throw new NotImplementedException();
        //}

        private Contexto contexto = new Contexto();

        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        //public void Alterar(Usuario usuario)
        //{

        //    contexto.Usuarios = usuario;
        //}

        //public IEnumerable<Usuario> Listar()
        //{
        //    return contexto.Select(u => u.Value);
        //}

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Where(u => u.Email == email)
                .Include(a => a.Permissoes)
                .FirstOrDefault();
        }
    }
}
