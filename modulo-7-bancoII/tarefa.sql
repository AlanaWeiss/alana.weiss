create or replace package pck_eliminarCidadesDuplicadas as
  procedure cidades_duplicadas;
 -- procedure clientes_cidades_duplicadas;
  procedure eliminar_cidades(pNome in varchar2, pUf in varchar2);
end;

create or replace package body pck_eliminarCidadesDuplicadas as
  procedure cidades_duplicadas is
   CURSOR C_ListaCidade IS
     Select Nome, 
            count(nome) as registros ,
            Uf
     From   cidade
     group by Nome, UF
    having count(nome)>1 
     Order  by 1;
    begin
      for c in C_ListaCidade loop
        eliminar_cidades(pNome=>c.nome, pUf=>c.uf);
      end loop;
    end cidades_duplicadas;

 /* procedure clientes_cidades_duplicadas(pNome in varchar2, pUf in varchar2) is
    begin
        Select cliente.Nome, cliente.idcidade
        from Cliente 
        inner join Cidade on cliente.idcidade = cidade.idcidade
        where cidade.nome = 'Abadiania' and cidade.uf = 'GO';
    end clientes_cidades_duplicadas;*/
    
  procedure eliminar_cidades (pNome in varchar2, pUf in varchar2) is
  
    begin
      update (select cliente.idcidade
             from cliente 
             inner join cidade on cidade.idcidade = cliente.idcidade
              where cidade.nome = pNome and cidade.uf =  pUf
            ) 
     set idcidade = (select min(cidade.idcidade)
                                    from cidade
                                     where cidade.nome = pNome and cidade.uf = pUf
                                  );
    end eliminar_cidades;
  end;