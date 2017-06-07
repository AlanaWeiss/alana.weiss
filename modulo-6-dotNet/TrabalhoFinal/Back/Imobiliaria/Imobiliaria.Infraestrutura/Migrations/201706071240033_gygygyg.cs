namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class gygygyg : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Reserva", "IdOpcional");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Reserva", "IdOpcional", c => c.Int());
        }
    }
}
