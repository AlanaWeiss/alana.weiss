select * from user_tables;

select user from dual; --pega o usuario que esta sendo utilizado

 EXEC dbms_stats.gather_schema_stats(USER); --alguma coisa para o last analyzed nao ficar mais null
--isso é uma package que dentro dela ha varios metodos. dentro dela ha um metodo que coleta as statisticas dos schemas do usuario
--podemos fazer isso quando demora muito as consultas, podemos atualizar as estatisticas