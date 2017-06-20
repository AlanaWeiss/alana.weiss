Create table LogCliente (
  IDLogCliente   integer not null,
  IDCliente      integer not null,
  Operacao       char(1) not null,
  Usuario        varchar2(50),
  Data           date default sysdate,
  Nome_Novo      varchar2(50),
  Nome_Antigo    varchar2(50),
    constraint PK_LogCliente 
       primary key (IDLogCliente)
);

Create sequence sqLogCliente;

select * from logcliente;

create or replace trigger TR_AUD2_CLIENTE
    after insert or update or delete on CLIENTE
    for each row
Declare
  v_idcliente   Integer;
  v_operacao    Char(1);
  v_nome_Antigo Cliente.Nome%type;
  v_nome_novo   Cliente.Nome%type;
Begin

  if INSERTING then
     v_operacao    := 'I';
     v_idcliente   := :new.idcliente;
     v_nome_novo   := :new.nome; 
     v_nome_antigo := NULL;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idcliente   := :old.idcliente;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     v_nome_novo   := :new.nome;       -- NOVO NOME
     v_nome_antigo := :old.nome;     -- ANTIGO NOME
  else
     v_operacao := 'D';
     v_idcliente   := :old.idcliente;  -- 
     v_nome_novo   := NULL;            -- EM OPERAÇÕES DE DELETE NÃO EXISTEM VALORES "NOVOS"
     v_nome_antigo := :old.nome;     -- NOME ANTES DA EXCLUSÃO
  end if;
    Insert into LogCliente (idlogcliente, idcliente, operacao, usuario, data, Nome_Antigo, Nome_Novo)
      values (sqlogcliente.nextval, v_idcliente, v_operacao, user, sysdate, v_nome_Antigo, v_nome_novo);

End TR_AUD2_CLIENTE;

Update cliente 
Set    nome = 'coca cola/ FL1'
Where  IDCliente = 100000;

select * from cliente;

commit;