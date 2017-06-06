using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Mapping
{
    class ReservaMap : EntityTypeConfiguration<Reserva>
    {
        public ReservaMap()
        {
            ToTable("Reserva");
            HasKey(x => x.Id);
            
            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);
            
            HasRequired(x => x.Produto)
                .WithMany()
                .HasForeignKey(x => x.IdProduto);
            
            HasOptional(x => x.Pacote)
                .WithMany()
                .HasForeignKey(x => x.IdPacote);
            
            HasOptional(x => x.Opcional)
                .WithMany()
                .HasForeignKey(x => x.IdOpcional);
        }
    }
}
