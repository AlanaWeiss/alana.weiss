--Cidades Duplicadas e clientes relacionados a elas

DECLARE
 CURSOR C_ListaCidade IS
     Select Nome, 
            count(nome) as registros ,
            Uf
     From   cidade
     group by Nome, UF
    having count(nome)>1 
     Order  by 1;
     
  CURSOR C_ListaCliente (pNomecidade in varchar2, pUfCidade in varchar2) IS
        Select cliente.Nome, cliente.IDCidade
        from Cliente 
        inner join Cidade on cliente.idcidade = cidade.idcidade
        where cidade.nome = pNomecidade and cidade.uf = pUfCidade;
BEGIN
 
   FOR reg IN C_ListaCidade LOOP
     DBMS_OUTPUT.PUT_LINE( '-----------------');
     DBMS_OUTPUT.PUT_LINE( 'Cidade: ' || reg.nome || '-'|| reg.uf);
    FOR i in C_ListaCliente(reg.nome,reg.uf) LOOP
      DBMS_OUTPUT.PUT_LINE( i.nome || i.idcidade);
      END LOOP;
   END LOOP;  
END;

create index IX_Cidade_NomeUF on Cidade(Nome, Uf);
create index IX_Cliente_Cidade on Cliente(IDCidade);

--Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
--Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).

DECLARE
vValorTotal pedido.valorpedido%type;
vIdPedido pedido.idpedido%type;

 CURSOR C_Pedido(pIDPedido in number) IS
     Select quantidade,
            precoUnitario
     From   PedidoItem
     where IdPedido = pIDPedido;
     
BEGIN
 vIdPedido := 162;
 vValorTotal := 0.0;
    FOR reg in C_Pedido(vIdPedido) LOOP 
        vValorTotal := vValorTotal + (reg.quantidade * reg.precounitario); 
    END LOOP;
      DBMS_OUTPUT.PUT_LINE( vValorTotal);
      update pedido 
      set valorpedido = vValorTotal
      where IdPedido = vIdPedido;
END;

--Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido nos últimos 6 meses 
--(considere apenas o mês, dia 01 do 6º mês anterior). Definir o atributo Situacao para I.

DECLARE
    CURSOR C_ClientesSemPedidos IS
        select c.IDCliente, c.Nome, c.situacao
        from cliente c inner join pedido p on p.idcliente = c.idcliente
        where idpedido not in (
                                select idpedido
                                from pedidoitem 
                                where p.datapedido >= add_months(trunc(sysdate), -6));
                                
BEGIN
    FOR reg IN C_ClientesSemPedidos LOOP
        UPDATE cliente 
        set situacao = 'I'
        where idcliente = reg.idcliente;
    END LOOP;
END;
commit;

--Faça uma rotina que receba dois parâmetros: IDProduto e Mês e Ano
--faça uma rotina que verifique no ANO/MÊS para o produto informado qual a lista de materiais (incluindo a quantidade) 
--é necessário para atender todos os Pedidos desde período. Deve imprimir o nome do material e quantidade total
DECLARE
    CURSOR C_ListaProdutos(Id IN NUMBER, Mes IN NUMBER, Ano IN NUMBER) IS
        SELECT p.IdProduto AS IdProduto, SUM(pi.Quantidade) Quantidade_Produto FROM Produto p
        JOIN PedidoItem pi ON p.IdProduto = pi.IdProduto AND p.IdProduto = Id
        JOIN Pedido ped ON ped.IDPEDIDO = pi.IDPEDIDO 
        WHERE TO_CHAR(ped.DATAPEDIDO, 'MM') = Mes AND TO_CHAR(ped.DATAPEDIDO, 'YYYY') = Ano
        GROUP BY p.IdProduto;
    CURSOR C_MateriaisDoProduto(IdProduto IN NUMBER) IS
        SELECT m.IdMaterial, m.Descricao, pm.Quantidade FROM Material m
        JOIN ProdutoMaterial pm ON m.IdMaterial = pm.IdMaterial AND pm.IdProduto = IdProduto;
BEGIN
    FOR reg IN C_ListaProdutos(10, 6, 2016) LOOP
        FOR item IN C_MateriaisProduto(reg.IdProduto) LOOP
            DBMS_OUTPUT.PUT_LINE(item.Descricao || ' - ' || (item.Quantidade * reg.Quantidade_Produto));
        END LOOP;
    END LOOP;
END;




    
