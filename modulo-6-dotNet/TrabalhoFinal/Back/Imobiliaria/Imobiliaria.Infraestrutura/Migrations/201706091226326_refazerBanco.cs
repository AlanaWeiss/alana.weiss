namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class refazerBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Cpf = c.String(),
                        Endereco = c.String(),
                        Genero = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(),
                        Preco = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descricao = c.String(),
                        Preco = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Imovel = c.String(),
                        Preco = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Reserva",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataDevolucaoPrevista = c.DateTime(nullable: false),
                        DataDevolucaoReal = c.DateTime(),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotalReal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ReservaAdicional",
                c => new
                    {
                        IdReserva = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdReserva, t.IdOpcional })
                .ForeignKey("dbo.Reserva", t => t.IdReserva, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdReserva)
                .Index(t => t.IdOpcional);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuario = c.Guid(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Reserva", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Reserva", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.ReservaAdicional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.ReservaAdicional", "IdReserva", "dbo.Reserva");
            DropForeignKey("dbo.Reserva", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropIndex("dbo.ReservaAdicional", new[] { "IdOpcional" });
            DropIndex("dbo.ReservaAdicional", new[] { "IdReserva" });
            DropIndex("dbo.Reserva", new[] { "IdProduto" });
            DropIndex("dbo.Reserva", new[] { "IdPacote" });
            DropIndex("dbo.Reserva", new[] { "IdCliente" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.ReservaAdicional");
            DropTable("dbo.Usuario");
            DropTable("dbo.Reserva");
            DropTable("dbo.Produto");
            DropTable("dbo.Permissao");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Cliente");
        }
    }
}
