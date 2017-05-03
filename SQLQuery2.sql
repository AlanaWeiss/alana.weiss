
-- VERIFICA O PREÇO DE CUSTO DO PRODUTO FAZENDO RELACAO COM A TABELA PRODUTOMATERIAL
-- PEGANDO A QUANTIDADE DO MATERIAL(PRODUTOMATERIAL) E O PREÇO DE CUSTO DELE(MATERIAL)

select SUM(ISNULL(pm.Quantidade, 1) * ma.PrecoCusto) 
from ProdutoMaterial pm
	inner join Material ma on pm.IDMaterial =ma.IDMaterial
where pm.IDProduto = 3