using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Mapping;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura
{
    class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEF")
        { }

        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Opcional> Opcionais { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Reserva> Reservas { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ReservaMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        }
    }
}
