/*Liste o nome do empregado, o nome do gerente e o departamento de cada um.*/

Select  emp.IDEmpregado, 
		emp.NomeEmpregado,
		emp.IDDepartamento as [IDDepartamento empregado],
		emp.IDGerente,
		ger.NomeEmpregado as [Nome Gerente] ,
		ger.IDDepartamento as [IDDepartamento gerente]
   from Empregado emp
	  inner join Empregado ger on emp.IDGerente = ger.IDEmpregado

/*Liste o deparamento (id e nome) com o empregado de maior salário.*/

Select TOP(1)
		dep.IDDepartamento  as IDDepartamento, 
		dep.NomeDepartamento as Departamento
From Empregado emp
inner join Departamento dep on dep.IDDepartamento = emp.IDDepartamento
order by emp.salario desc

/*Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, 
este reajuste deve ser de 17,3%.*/

SELECT * INTO CopiaEmpregado2 FROM Empregado

BEGIN TRANSACTION

UPDATE Empregado
SET Salario = Salario + Salario*0.173
from Empregado emp
inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento
where dep.Localizacao = 'SAO PAULO'
 
 Select salario from Empregado where IDDepartamento = 10

COMMIT

ROLLBACK

/*
Liste todas as cidades duplicadas (nome e UF iguais).
*/
select Nome as Cidade, count(Nome) as [Cidade Repetida], UF as Estado
from Cidade
group by Nome, UF 
having count(nome)>1 

/*EXPLICAÇÃO VIEWS*/

Create view vwCidades_Gauchas as
   Select IDCidade,
          Nome
   From   Cidade
   Where  UF = 'RS';

Select IDCidade, nome from vwCidades_Gauchas

/*Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
Mas atenção! apenas a cidade com maior ID deve ser alterada.*/

BEGIN TRANSACTION

update cidade
	set cidade.Nome = cidade.Nome + '*'
	from Cidade cidade
	inner join Cidade city on cidade.IDCidade != city.IDCidade
	and cidade.Nome = city.Nome
	and cidade.UF = city.UF
	where cidade.IDCidade > city.IDCidade

select nome from cidade

COMMIT