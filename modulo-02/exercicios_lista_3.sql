/*
 Alteração para adicionar a informação da data de nascimento do Empregado
*/
alter table empregado add DataNascimento date;

begin transaction
go

update Empregado set DataNascimento = convert(date, '22/12/1962', 103) where idEmpregado = 	7369;
update Empregado set DataNascimento = convert(date, '25/02/1961', 103) where idEmpregado = 	7499;
update Empregado set DataNascimento = convert(date, '27/02/1962', 103) where idEmpregado = 	7521;
update Empregado set DataNascimento = convert(date, '09/04/1952', 103) where idEmpregado = 	7566;
update Empregado set DataNascimento = convert(date, '06/10/1950', 103) where idEmpregado = 	7654;
update Empregado set DataNascimento = convert(date, '07/05/1959', 103) where idEmpregado = 	7698;
update Empregado set DataNascimento = convert(date, '15/06/1956', 103) where idEmpregado = 	7782;
update Empregado set DataNascimento = convert(date, '13/12/1966', 103) where idEmpregado = 	7788;
update Empregado set DataNascimento = convert(date, '22/11/1961', 103) where idEmpregado = 	7839;
update Empregado set DataNascimento = convert(date, '15/09/1954', 103) where idEmpregado = 	7844;
update Empregado set DataNascimento = convert(date, '22/01/1944', 103) where idEmpregado = 	7876;
update Empregado set DataNascimento = convert(date, '10/12/1955', 103) where idEmpregado = 	7900;
update Empregado set DataNascimento = convert(date, '09/12/1957', 103) where idEmpregado = 	7902;
update Empregado set DataNascimento = convert(date, '30/01/1955', 103) where idEmpregado = 	7934;
update Empregado set DataNascimento = convert(date, '24/01/1969', 103) where idEmpregado = 	7940;

commit
go

select * from empregado;

/*
1) Faça uma consulta que liste o total de empregados admitidos no ano de 1980. 
Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão
*/

Select  IDEmpregado, 
		NomeEmpregado as Nome, 
		DATEDIFF(year, DataNascimento, DataAdmissao) as IdadeEmpregadoNaAdimissao
		from Empregado
		Where datepart(year, DataAdmissao) = 1980;

/*
2) Cargo que possui mais empregados
*/

Select top(1) Cargo from Empregado;

/*
3) Listar os estados e o total de cidades existente em cada estado na tabela cidade
*/

Select UF as Estados, count(1) as TotalCidades
from Cidade
Group by UF

/*
Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. 
Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) 
que não ocupam o cargo de 'Atendente' devem ter o departamento (IDDepartamento) atualizado para este novo registro (inovação)
*/

BEGIN TRANSACTION
GO

insert into Departamento values (98,'Inovação', 'SÃO LEOPOLDO');

COMMIT 

BEGIN TRANSACTION 

update Empregado set IDDepartamento = 98 where datepart(MONTH, DataAdmissao) = 12 and cargo != 'Atendente';

COMMIT

SELECT * from empregado