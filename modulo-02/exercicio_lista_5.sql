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
BEGIN TRANSACTION

UPDATE Empregado
SET Salario = Salario + Salario*0.173
from Empregado emp
inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento
where Departamento.Localizacao = 'SÃO PAULO'
 

ROLLBACK

SELECT * INTO CopiaEmpregado2 FROM Empregado

UPDATE EMPREGADO
SET SALARIO = SALARIO * 1.173
FROM EMPREGADO
INNER JOIN DEPARTAMENTO ON EMPREGADO.IDDepartamento = DEPARTAMENTO.IDDepartamento
WHERE Departamento.Localizacao = 'SAO PAULO'

/*
Exercício 4
Cidades duplicadas
Liste todas as cidades duplicadas (nome e UF iguais).
*/

(
SELECT COUNT(1) as [Quantidade de Cidades Iguais],Nome as [Nome Da Cidade], UF as [Unidade Federativa] FROM CIDADE 
GROUP BY Nome,uf
having COUNT(1) >= 2
)
