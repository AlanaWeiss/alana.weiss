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
     DBMS_OUTPUT.PUT_LINE( 'Cidade: ' || reg.nome || '-'|| reg.uf);
    FOR i in C_ListaCliCid(reg.nome,reg.uf) LOOP
      DBMS_OUTPUT.PUT_LINE( i.nome);
      END LOOP;
   END LOOP;  
END;