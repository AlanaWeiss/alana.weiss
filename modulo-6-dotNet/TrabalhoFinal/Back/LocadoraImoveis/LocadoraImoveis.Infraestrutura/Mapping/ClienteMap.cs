using LocadoraImoveis.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraImoveis.Infraestrutura.Mapping
{
    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasRequired(x => x.Endereco)
                .WithMany()
                .HasForeignKey(x => x.IdEndereco);
        }
    }
}
