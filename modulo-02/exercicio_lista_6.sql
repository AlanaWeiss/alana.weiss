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



select*from cidade