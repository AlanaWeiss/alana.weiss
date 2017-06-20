create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdar� as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribu� valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme defin��o das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Quest�o "A" - implementar rotina que ir� inserir um novo concurso
    */
  procedure geraProximoConcurso as
    v_IdConcurso       CONCURSO.IDCONCURSO%type;
    v_IdConcursoAtual  CONCURSO.IDCONCURSO%type;
    v_ArrecadacaoPas   APOSTA.VALOR%type;
    v_PremioCorrente   CONCURSO.PREMIO_SENA%type;
    v_DataConcurso     CONCURSO.DATA_SORTEIO%type;
   begin
      
      v_IdConcurso       := buscaUltimoConcurso();
      v_IdConcursoAtual  := buscaUltimoConcurso()+1;
      v_ArrecadacaoPas   := buscaApostas(v_IdConcurso);
      v_PremioCorrente   := 0.453 * v_ArrecadacaoPas;
      v_DataConcurso     := sysdate+7;        
      
     salvaConcurso (v_IdConcursoAtual,
                          v_DataConcurso,
                           v_PremioCorrente);
   end geraProximoConcurso;
   
   
   /*Fun��o que busca o ultimo concurso*/
   function buscaUltimoConcurso return number as
        -- 
        v_IDUltimoConcurso  CONCURSO.IDCONCURSO%type; -- herdar� as propriedades do campo IDConcurso
      begin
        
        -- busca ID 
        select max(idconcurso)
        into   v_IDUltimoConcurso -- atribu� valor para a variavel
        from   concurso;
        
        return v_IDUltimoConcurso;
      
      end buscaUltimoConcurso;
      
        /*Fun��o que busca a arrecada��o do ultimo concurso*/
   function buscaApostas(pIDConcurso in number) return number as
        -- 
        v_Arrecadao  APOSTA.VALOR%type; -- herdar� as propriedades do campo valor
        
      begin
        
        -- busca arrecada��o 
        select sum(a.valor) 
        into v_Arrecadao
        from aposta a
        inner join concurso c on a.idconcurso = c.idconcurso
        where  a.idconcurso = pIDConcurso;
        
        return v_Arrecadao;
      
      end buscaApostas;
      
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Quest�o "B" - implementar rotina que ir� inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
   begin
      null; --> codar aqui
   end atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;