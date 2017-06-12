 
Create user CRESCER2017 identified by CRESCER2017;

grant connect, resource, create view to CRESCER2017;

alter user CRESCER2017 default tablespace CRESCER17DAT;

create directory ORACLE_DUMP as 'C:\ORACLE\DATAPUMP';