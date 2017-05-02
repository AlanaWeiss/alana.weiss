/*
1) Liste todos os projetos que tiveram atrasos no início da obra,
 exibir também o tempo previsto (em meses), e o tempo realizado (em meses) para a conclusão da obra.
*/

Select Projeto,
	   DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) as [Tempo previsto (meses)],
	   DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) as [Tempo realizado (meses)]
 from Licitacao
 where Data_Inicio_Real > Data_Inicio_Prev

 /* 
2) Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado também o valor médio por profissional.
*/
Select top(10) Empresa_Licitante,
	SUM(Valor_Realizado) as Faturamento,
	SUM(Valor_Realizado)/SUM(Profissionais) as [Valor médio por profissional]
	from Licitacao
	group by Empresa_Licitante
	order by Faturamento DESC

/*
3) Liste as TOP 10 cidades com maior arrecação de impostos.
*/

Select top(10)Municipio, 
		SUM(Imposto_Municipal) as [Imposto Arrecadao]
		from Licitacao
		group by Municipio
		order by [Imposto Arrecadao] DESC

/*
4) Liste todos os projetos que tiveram a data de início (real) ocorrendo em finais de semana (sábado ou domingo).
*/

Select Projeto from Licitacao
	where DATEPART(weekday, Data_Inicio_Real) = 1 /*domingo*/ OR DATEPART(weekday, Data_Inicio_Real) = 7 /*sabado*/


/*
5) Liste todas as empresas que tiveram (ou terão) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/

Select Empresa_Licitante
	from Licitacao
	group by Empresa_Licitante
	having SUM(Valor_Previsto) > (0.5* SUM(Faturamento_1Ano_Anterior))

/*
6) Liste os projetos exibindo o custo real do projeto. Caso o projeto seja de esfera federal deve ser descontado o imposto federal, 
e assim respectivamente para as esferas estaduais e municipais.
*/ 

Select *, CustoReal =
					 case 
					 when Esfera = 'Federal' then (Valor_Realizado - Imposto_Federal)
					 when Esfera = 'Estadual' then (Valor_Realizado - Imposto_Estadual)
					 when Esfera = 'Municipal' then (Valor_Realizado - Imposto_Municipal)
					 end
					 from Licitacao;

/*
7) O projeto 17255 foi suspenso, o motivo foi o elevado custo para o orçamento anual do município. A partir de uma investigação mais detalhada 
foi visto que esse motivo não era a verdadeira razão. Explique por que este motivo não é válido apresentando uma consulta com dados.
*/
Select *, DATEDIFF(MONTH, Data_Fim_Prev, Data_Fim_Real) from licitacao where Identificador=17255;

-- O motivo para a suspensão do projeto foi a data de fim real ultrapassar em 7 meses a data prevista para o fim 