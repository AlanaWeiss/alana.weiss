SELECT * FROM PEDIDO;
SELECT * FROM PEDIDOITEM;

Create view vwProdutosCompradosHa4Meses as
select IDProduto FROM PedidoItem INNER JOIN Pedido ON PedidoItem.IDPedido = Pedido.IDPedido
where MONTHS_BETWEEN 
   (TO_DATE(sysdate),
    TO_DATE(Pedido.DataPedido) ) < = 4;
    
-- Liste os produtos (id e nome) que n�o tiveram nenhuma compra nos �ltimos quatro meses.
select p.IDProduto, p.Nome from Produto p where p.IDProduto not in
(select * from VwProdutosCompradosHa4Meses);
    
-- Altere o status dos produtos (campo situacao) que n�o tiveram nenhum pedido nos �ltimos quatro meses.
update Produto set situacao = 'I' where produto.IDProduto not in
select * from VwProdutosCompradosHa4Meses);

-- Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2017).

select quantidade as QuantidadeProdutosVendidos from (
    select pedi.IDPedido,
        sum(pedi.Quantidade) as quantidade, 
	pedi.IDProduto  
from PedidoItem pedi inner join Produto p on pedi.IDProduto = p.IDProduto
    inner join Pedido pe on pi.IDPedido = pe.IDPedido 
    where pe.DataPedido BETWEEN date '2017-01-01' AND
    TO_DATE(sysdate)
    AND p.IDProduto = :id
  );

COMMIT;

