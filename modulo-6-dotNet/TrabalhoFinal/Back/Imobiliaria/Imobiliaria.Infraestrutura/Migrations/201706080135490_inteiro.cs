namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class inteiro : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Reserva", "ValorTotal", c => c.Int(nullable: false));
            AlterColumn("dbo.Reserva", "ValorTotalReal", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Reserva", "ValorTotalReal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Reserva", "ValorTotal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
