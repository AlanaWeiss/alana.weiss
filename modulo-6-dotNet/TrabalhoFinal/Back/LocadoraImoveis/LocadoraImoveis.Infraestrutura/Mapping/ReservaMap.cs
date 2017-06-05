using LocadoraImoveis.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraImoveis.Infraestrutura.Mapping
{
    class ReservaMap : EntityTypeConfiguration<Reserva>
    {
        public ReservaMap()
        {
            ToTable("Reserva");

            HasMany(x => x.Itens).WithMany().Map(x =>
            {
                x.MapLeftKey("IdReserva");
                x.MapRightKey("IdItens");
                x.ToTable("ReservaItens");
            });
        }
    }
}
