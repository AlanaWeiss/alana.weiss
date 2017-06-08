namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class eww77qeq : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.ReservaOpcioonal", newName: "ReservaAdicional");
            RenameColumn(table: "dbo.ReservaAdicional", name: "IdOpcicional", newName: "IdOpcional");
            RenameIndex(table: "dbo.ReservaAdicional", name: "IX_IdOpcicional", newName: "IX_IdOpcional");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.ReservaAdicional", name: "IX_IdOpcional", newName: "IX_IdOpcicional");
            RenameColumn(table: "dbo.ReservaAdicional", name: "IdOpcional", newName: "IdOpcicional");
            RenameTable(name: "dbo.ReservaAdicional", newName: "ReservaOpcioonal");
        }
    }
}
