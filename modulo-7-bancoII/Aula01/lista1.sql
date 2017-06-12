SELECT * FROM PEDIDO;
SELECT * FROM PEDIDOITEM;

select p.IDProduto, 
	   p.Nome
  inner join pedido ped on pedI.Idpedido = ped.idpedido
  where  ped.DATAPEDIDO = 
from   Produto p where p.idproduto not in 
( select pedi.idproduto 
  from pedidoitem pedi  ADD_MONTHS(sysdate, -4)
);

