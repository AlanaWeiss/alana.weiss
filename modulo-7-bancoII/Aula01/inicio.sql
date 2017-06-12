create table Pessoa ( 
  IDPessoa integer not null,
  Nome varchar2(30) not null,
    constraint PK_Pessoa primary key ( IDPessoa )
); 

Create sequence SQPessoa;

Insert Into Pessoa (IDPessoa, Nome) Values (SQPessoa.nextval, 'Andre');

Select * from pessoa;

commit;