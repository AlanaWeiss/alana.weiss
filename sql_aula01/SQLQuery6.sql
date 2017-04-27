/*-- comando que altera uma tabela, nesse caso o tamanho maximo da variavel placa
ALTER TABLE CARRO ALTER COLUMN PLACA VARCHAR(8);
	-- retornando todos os registros
Select * From Carro Where proprietario = 'julia de souza';

insert into carro 
   (placa, cor, marca, modelo, proprietario, email, telefone) 
  values 
   ('IAB-0101', 'preto', 'honda', 'civic', 'augusta cavalcante', 'augusta.cavalcante@company.com', '8778-4556');

   -- retornando apenas linhas onde o valor da coluna "proprietario" seja igual à 'julia de souza'
insert into carro
     (placa, cor, marca, modelo, proprietario, email, telefone) 
   values
     ('IXT-7181', 'cinza', 'volkswagen', 'passat', 'julia de souza', 'julia.souza@company.com', '9660-0669');

*/

Create table Pais
    ( IDPais   int         not null,
      Nome     varchar(50) not null,
      Sigla    varchar(3),
         constraint PK_Pais primary key (IDPais) -- chave primaria
    )

	-- inserindo um país 
	insert into Pais (IDPais, Nome, Sigla) -- recomendavel sempre incluir os atributos que tem na tabela
	 values (1, 'Brasil', 'BRA');

-- com a chave primaria garantimos que dois elementos nao podem ser duplicados 

-- para retornar tudo o que tem na tabela 
	Select * from pais;

-- para retornar tudo o que tem na tabela na chave 1
	Select * from pais where idpais = 1;

-- altera a tabela para incluir novo atributo	
	Alter table Pais add DDI varchar(5);

-- elimina completamente a tabela 
 Drop table Pais;

 -- criando tabela com identity
 Create table Pais
    ( IDPais   int  IDENTITY  not null,
      Nome     varchar(50)    not null,
      Sigla    varchar(3),
	  Situacao char(1),
		constraint PK_Pais primary key (IDPais),
		constraint UK_Pais_Nome unique (nome),
		constraint CC_pais_Situacao check (Situacao in ('A','I'))
    )

-- alterando para ter chave primaria
Alter table Pais add constraint PK_Pais primary key (IDPais);
-- inserindo um objeto

insert into Pais(Nome, Sigla, Situacao)
	values('brasil2','bra','A');

insert into Pais(Nome, Sigla, Situacao)
	values('brasil22','bra','I');

Select * from pais;

Alter table Pais add constraint UK_Pais_Nome unique (nome); 