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
                .Map(x => x.MapKey("IdCliente"));
            
            HasRequired(x => x.Produto)
                .WithMany()
                .Map(x => x.MapKey("IdProduto"));


            HasOptional(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));

            HasMany(x => x.Opcional).WithMany().Map(x =>
            {
                x.MapLeftKey("IdReserva");
                x.MapRightKey("IdOpcicional");
                x.ToTable("ReservaOpcioonal");
            });
        }
    }
}
