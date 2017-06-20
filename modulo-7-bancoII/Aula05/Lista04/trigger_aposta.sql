create or replace trigger TR_AUD_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  V_Operacao      Char(1);
  V_IdConcurso    Concurso.Idconcurso%type;
  V_Idaposta      Aposta.Idaposta%type;
Begin

  if INSERTING then
     v_operacao     := 'I';
     V_Idaposta     := :new.idaposta;
     V_IdConcurso   := :new.idconcurso; 
  elsif UPDATING then
     v_operacao     := 'U';       
     V_Idaposta     := :old.idaposta;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     V_Idconcurso   := :old.idconcurso;
  else
     v_operacao    := 'D';
     v_idaposta    := :old.idaposta;
  end if;
    Insert into Log_Aposta (IDLogAposta, Idaposta, Idconcurso, operacao, usuario, data)
      values (sqLogAposta.nextval, v_idaposta, V_Idconcurso, v_operacao, user, sysdate);

End TR_AUD_APOSTA;