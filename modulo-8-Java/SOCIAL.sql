CREATE TABLE Usuario (
	email varchar2,
	nome varchar2,
	sexo varchar2,
	dataNascimento DATE,
	senha varchar2,
	role varchar2,
	organizacao varchar2,
	nick varchar2,
	idUsuario number,
	constraint USUARIO_PK PRIMARY KEY (idUsuario)
CREATE sequence USUARIO_SEQ
/
CREATE trigger BI_USUARIO
  before insert on USUARIO
  for each row
begin
  select USUARIO_SEQ.nextval into :NEW.idUsuario from dual;
end;
/

)
/
CREATE TABLE Amizade (
	idAmizade bfile,
	idSolicitante number,
	idSolicitado number,
	status char,
	constraint AMIZADE_PK PRIMARY KEY (idAmizade)
CREATE sequence AMIZADE_SEQ
/
CREATE trigger BI_AMIZADE
  before insert on AMIZADE
  for each row
begin
  select AMIZADE_SEQ.nextval into :NEW.idAmizade from dual;
end;
/

)
/
CREATE TABLE Post (
	idPost bfile,
	mensagem varchar2,
	data DATE,
	idUsuario number,
	curtidas number,
	constraint POST_PK PRIMARY KEY (idPost)
CREATE sequence POST_SEQ
/
CREATE trigger BI_POST
  before insert on POST
  for each row
begin
  select POST_SEQ.nextval into :NEW.idPost from dual;
end;
/

)
/
CREATE TABLE Curtida (
	idCurtida number,
	idUsuario number,
	constraint CURTIDA_PK PRIMARY KEY (idCurtida)
CREATE sequence CURTIDA_SEQ
/
CREATE trigger BI_CURTIDA
  before insert on CURTIDA
  for each row
begin
  select CURTIDA_SEQ.nextval into :NEW.idCurtida from dual;
end;
/

)
/

ALTER TABLE Amizade ADD CONSTRAINT Amizade_fk0 FOREIGN KEY (idSolicitante) REFERENCES Usuario(idUsuario);
ALTER TABLE Amizade ADD CONSTRAINT Amizade_fk1 FOREIGN KEY (idSolicitado) REFERENCES Usuario(idUsuario);

ALTER TABLE Post ADD CONSTRAINT Post_fk0 FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);
ALTER TABLE Post ADD CONSTRAINT Post_fk1 FOREIGN KEY (curtidas) REFERENCES Curtida(idCurtida);

ALTER TABLE Curtida ADD CONSTRAINT Curtida_fk0 FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);
