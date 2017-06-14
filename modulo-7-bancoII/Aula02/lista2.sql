DECLARE
 CURSOR C_ListaCli IS
     Select Nome, 
            count(nome) as registros ,
            Uf
     From   cidade
     group by Nome, UF
    having count(nome)>1 
     Order  by 1;
     
  CURSOR C_ListaCliCid (pNomecidade in string, pUfCidade in string) IS
        Select cliente.Nome
        from Cliente 
        inner join Cidade on cidade.nome = pNomecidade and cidade.uf = pUfCidade
        where cliente.idcidade = cidade.idcidade;
BEGIN
 
   FOR reg IN C_ListaCli LOOP
     DBMS_OUTPUT.PUT_LINE( '-----------------');
     DBMS_OUTPUT.PUT_LINE( 'Cidade: ' || reg.nome || '-'|| reg.uf);
    FOR i in C_ListaCliCid(reg.nome,reg.uf) LOOP
      DBMS_OUTPUT.PUT_LINE( i.nome);
      END LOOP;
   END LOOP;  
END;

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








