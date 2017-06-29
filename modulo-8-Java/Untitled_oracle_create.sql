CREATE TABLE Usuario (
	email varchar2,
	nome varchar2,
	sexo varchar2,
	dataNascimento DATE,
	senha varchar2,
	role varchar2,
	idUsuario long,
	constraint USUARIO_PK PRIMARY KEY (email))
  
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
CREATE TABLE Solicitacao (
	idSolicitante number,
	idSolicitado number,
	idAmizade number,
	constraint SOLICITACAO_PK PRIMARY KEY (idAmizade)
CREATE sequence SOLICITACAO_SEQ
/
CREATE trigger BI_SOLICITACAO
  before insert on SOLICITACAO
  for each row
begin
  select SOLICITACAO_SEQ.nextval into :NEW.idAmizade from dual;
end;
/

)
/
CREATE TABLE Amizade (
	idAmizade number,
	idSolicitante number,
	idSolicitado number,
	constraint CONSTRAINT AMIZADE_PK primary key(idSolicitante,idSolicitado)

CREATE TABLE Publicacao (
	idPublicacao number,
	idUsuario number,
	mensagem varchar2,
	dataPublicacao DATE,
	curtida number,
	constraint PUBLICACAO_PK PRIMARY KEY (idPublicacao)
CREATE sequence PUBLICACAO_SEQ
/
CREATE trigger BI_PUBLICACAO
  before insert on PUBLICACAO
  for each row
begin
  select PUBLICACAO_SEQ.nextval into :NEW.idPublicacao from dual;
end;
/

)
/
CREATE TABLE Curtidas (
	idCurtida number,
	idUsuario number
)
/

ALTER TABLE Solicitacao ADD CONSTRAINT Solicitacao_fk0 FOREIGN KEY (idSolicitante) REFERENCES Usuario(idUsuario);
ALTER TABLE Solicitacao ADD CONSTRAINT Solicitacao_fk1 FOREIGN KEY (idSolicitado) REFERENCES Usuario(idUsuario);

ALTER TABLE Amizade ADD CONSTRAINT Amizade_fk0 FOREIGN KEY (idSolicitante) REFERENCES Solicitacao(idSolicitante);
ALTER TABLE Amizade ADD CONSTRAINT Amizade_fk1 FOREIGN KEY (idSolicitado) REFERENCES Solicitacao(idSolicitado);

ALTER TABLE Publicacao ADD CONSTRAINT Publicacao_fk0 FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);
ALTER TABLE Publicacao ADD CONSTRAINT Publicacao_fk1 FOREIGN KEY (curtida) REFERENCES Curtidas(idCurtida);

ALTER TABLE Curtidas ADD CONSTRAINT Curtidas_fk0 FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

