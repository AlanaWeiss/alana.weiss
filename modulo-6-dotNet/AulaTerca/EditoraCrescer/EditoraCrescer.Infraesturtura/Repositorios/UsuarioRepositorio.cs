using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
   public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public Usuario buscar(string email)
        {
            return contexto.Usuarios.Where(user => user.Email == email).FirstOrDefault();
        }

        public Usuario cadastrar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();

            return usuario;
        }

        public Usuario alterar()
        {
            throw new NotImplementedException();
        }
    }
}
