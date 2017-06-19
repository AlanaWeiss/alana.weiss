--Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso. 
--Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.

select Cid.Uf, count(ap.idcidade) as QtdAposta, sum(Ap.Valor) as ValorArrecadacaoEstado
from Cidade Cid inner join Aposta Ap on Ap.Idcidade = Cid.Idcidade
where cid.idcidade = Ap.Idcidade
group by Cid.Uf
order by QtdAposta desc, ValorArrecadacaoEstado desc;

--Crie uma view para consultar possibilidades de fraudes.
--Inicialmente identifique apostas com registro (log) de criação/alteração executado após a data do sorteio.

Create or replace view vwApostaCriadaOuAltAposSorteio as
select log_aposta.IDAposta--, log_numero_aposta.numero
FROM Log_Aposta
INNER JOIN Concurso  ON Concurso.IDConcurso = Log_Aposta.Idconcurso
inner join log_numero_aposta on log_numero_aposta.idaposta = log_aposta.idaposta
where Concurso.Data_Sorteio < Log_Aposta.data or Concurso.Data_Sorteio < Log_Numero_Aposta.Data; 









