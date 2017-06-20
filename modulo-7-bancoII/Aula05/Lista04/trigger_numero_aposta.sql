create or replace trigger TR_AUD_NUMERO_APOSTA
    after insert or update or delete on NUMERO_APOSTA
    for each row
Declare
  V_Operacao        Char(1);
  V_Numero          Numero_Aposta.Numero%type;
  v_numero_novo      Numero_Aposta.Numero%type;
  V_Idaposta        Aposta.Idaposta%type;
  v_IdNumeroAposta   Aposta.Idaposta%type;
Begin

  if INSERTING then
     v_operacao        := 'I';
     V_Idaposta        := :new.idaposta;
     V_Idnumeroaposta  := :new.idnumero_aposta;
     V_Numero          := null;
     V_Numero_Novo     := :new.numero;
  elsif UPDATING then
     v_operacao         := 'U';       
     V_Idaposta         := :old.idaposta;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     V_Idnumeroaposta   := :old.idnumero_aposta;
     v_numero_Novo      := :new.numero;
     v_numero           := :old.numero;
  else
     v_operacao    := 'D';
     v_idaposta    := :old.idaposta;
     V_Idnumeroaposta   := :old.idnumero_aposta;
     v_numero           := :old.numero;
     v_numero_Novo      := null;
  end if;
    Insert into Log_Numero_Aposta (IDLogNumero_Aposta, Idaposta, IDNUMERO_APOSTA, NUMERO, numeroantigo,operacao, usuario, data)
      values (sqLogNumeroAposta.nextval, v_idaposta, V_Idnumeroaposta, v_numero_Novo, v_numero, v_operacao, user, sysdate);

End TR_AUD_NUMERO_APOSTA;