CREATE TABLE Produto (
    Id INT IDENTITY(1,1) NOT NULL CONSTRAINT [PK_Produto] PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Preco DECIMAL(12,2) NOT NULL,
    Estoque INT NOT NULL
);

INSERT INTO Produto(Nome, Preco, Estoque) VALUES ('Mousepad', 19.97, 10)

SELECT * FROM Produto
SELECT @@IDENTITY


CREATE TABLE Pedido (
	Id INT IDENTITY(1,1) NOT NULL CONSTRAINT [PK_Pedido] PRIMARY KEY,
	NomeCliente VARCHAR(256) NOT NULL,
);

CREATE TABLE ItemPedido (
	Id INT IDENTITY(1,1) NOT NULL CONSTRAINT [PK_ItemPedido] PRIMARY KEY,
	PedidoId INT NOT NULL CONSTRAINT [FK_ItemPedio_Pedido] FOREIGN KEY REFERENCES Pedido(Id),
	ProdutoId INT NOT NULL CONSTRAINT [FK_ItemPedio_Produto] FOREIGN KEY REFERENCES Produto(Id),
	Quantidade INT NOT NULL
);