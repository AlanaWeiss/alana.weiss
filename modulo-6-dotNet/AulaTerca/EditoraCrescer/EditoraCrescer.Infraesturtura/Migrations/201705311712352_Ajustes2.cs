namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Ajustes2 : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            DropColumn("dbo.Livros", "IdRevisor");
            RenameColumn(table: "dbo.Livros", name: "Revisor_Id", newName: "IdRevisor");
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int());
            RenameColumn(table: "dbo.Livros", name: "IdRevisor", newName: "Revisor_Id");
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Autores", "Id");
        }
    }
}
