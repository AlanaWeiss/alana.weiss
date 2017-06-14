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

--Fa�a uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
--Esta rotina deve receber por parametro o IDPedido e ent�o verificar o valor total de seus itens (quantidade x valor unit�rio).
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

--











