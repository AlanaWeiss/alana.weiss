namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ineito : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Opcional", "Preco", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Opcional", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
