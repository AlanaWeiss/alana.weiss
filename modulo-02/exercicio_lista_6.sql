select * from Cliente

/*Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome*/

Select top (1) 
		subnome.primeiroNome as NomeCliente,
		count(subnome.primeiroNome) as TotalOcorrencia
from (SELECT (Substring(cliente.Nome, 1, CHARINDEX(' ', cliente.Nome)-1)) AS primeiroNome FROM cliente) as subnome
group by subnome.primeiroNome
order by TotalOcorrencia DESC

/*Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.*/

select * from Pedido

select COUNT(IDPedido) as [Qtd Pedidos],
       SUM(ValorPedido) as [Valor Pedidos] 
from   Pedido 
where  DATEPART(MONTH,DataPedido) = 4 AND  DATEPART(YEAR,DataPedido) = 2017

/*Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), 
liste tamb�m qual o Estado possu� o menor n�mero de clientes*/


Select top(1)
	cid.UF  as Estado, 
	count(c.Nome) as [Qtd Clientes]
From Cliente c
inner join Cidade cid on cid.IDCidade = c.IDCidade
group by cid.UF
order by count(c.Nome) desc



select*from --cidade
Produto where Nome = 'Galocha Maragato'

/*Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:

Nome: Galocha Maragato
Pre�o de custo: 35.67
Pre�o de venda: 77.95
Situa��o: A */

begin transaction 

insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao) values ('Galocha Maragato', 35.67, 77.95, 'A')

commit 
rollback

/*Identifique e liste os produtos que n�o tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, 
pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).

=> Obs.: o produto criado anteriormente dever� ser listado (apenas este)*/

Select * from PedidoItem
SELECT * from Produto
select * from Pedido

Select p.IDProduto, 
	   p.Nome
from   Produto p
Where  NOT EXISTS (Select pditem.IDProduto
					from  PedidoItem pditem
					where p.IDProduto = pditem.IDProduto)

/*Liste os 30 produtos que mais geraram lucro em 2016.*/

Select top(30) 