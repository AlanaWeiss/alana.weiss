Create table LogCliente_Operacao (
  IDLogCliente   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
    constraint PK_LogCliente_Operacao 
       primary key (IDLogCliente)
);

Create sequence sqLogCliente_Operacao;



create or replace
trigger TR_AUD1_CLIENTE
    after insert or update or delete on CLIENTE
Declare
  v_operacao char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogCliente_Operacao (idlogcliente, data, usuario, operacao)
      values (sqlogcliente_operacao.nextval, sysdate, user, v_operacao);

End TR_AUD1_CLIENTE;


insert into cliente (idcliente, nome, razaosocial) 
 values (100000, 'coca cola/ FL1', 'coca cola F1');

insert into cliente (idcliente, nome, razaosocial) 
 values (100001, 'coca cola/ FL2', 'coca cola F2');

insert into cliente (idcliente, nome, razaosocial) 
 values (100002, 'coca cola/ FL3', 'coca cola F3');

insert into cliente (idcliente, nome, razaosocial) 
 values (100003, 'coca cola/ FL4', 'coca cola F4');

insert into cliente (idcliente, nome, razaosocial) 
 values (100004, 'coca cola/ FL5', 'coca cola F5');
 
 Select * from logcliente_operacao;

Update cliente 
Set    nome = upper(nome)
Where  IDCliente between 100000 and 100003;

select * from cliente Where  IDCliente between 100000 and 100003;
rollback;