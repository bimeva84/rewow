--------------------------------------------------------
-- Archivo creado  - viernes-octubre-23-2020   
--------------------------------------------------------
REM INSERTING into C##REWOW.VACUNA
SET DEFINE OFF;
Insert into C##REWOW.VACUNA (VACUNA_ID,VACUNA_NUMERO,VACUNA_TIPO_VACUNA_ID,VACUNA_FECHA) values ('1','1','1',to_date('31/10/20','DD/MM/RR'));
Insert into C##REWOW.VACUNA (VACUNA_ID,VACUNA_NUMERO,VACUNA_TIPO_VACUNA_ID,VACUNA_FECHA) values ('2','2','2',to_date('01/11/20','DD/MM/RR'));
Insert into C##REWOW.VACUNA (VACUNA_ID,VACUNA_NUMERO,VACUNA_TIPO_VACUNA_ID,VACUNA_FECHA) values ('3','3','3',to_date('26/12/20','DD/MM/RR'));
Insert into C##REWOW.VACUNA (VACUNA_ID,VACUNA_NUMERO,VACUNA_TIPO_VACUNA_ID,VACUNA_FECHA) values ('4','4','4',to_date('24/12/20','DD/MM/RR'));
REM INSERTING into C##REWOW.TIPO_VACUNA
SET DEFINE OFF;
Insert into C##REWOW.TIPO_VACUNA (TIPO_VACUNA_ID,TIPO_VACUNA_DESC) values ('1','VACUNA1');
Insert into C##REWOW.TIPO_VACUNA (TIPO_VACUNA_ID,TIPO_VACUNA_DESC) values ('2','VACUNA2');
Insert into C##REWOW.TIPO_VACUNA (TIPO_VACUNA_ID,TIPO_VACUNA_DESC) values ('3','VACUNA3');
Insert into C##REWOW.TIPO_VACUNA (TIPO_VACUNA_ID,TIPO_VACUNA_DESC) values ('4','VACUNA4');
REM INSERTING into C##REWOW.TIPO_MASCOSTA
SET DEFINE OFF;
Insert into C##REWOW.TIPO_MASCOSTA (TIPO_MASCOTA_ID,TIPO_MASCOTA_DESC,TIPO_MASCOTA_ESTADO) values ('1','PERRO','A');
Insert into C##REWOW.TIPO_MASCOSTA (TIPO_MASCOTA_ID,TIPO_MASCOTA_DESC,TIPO_MASCOTA_ESTADO) values ('2','GATO','A');
Insert into C##REWOW.TIPO_MASCOSTA (TIPO_MASCOTA_ID,TIPO_MASCOTA_DESC,TIPO_MASCOTA_ESTADO) values ('3','PEZ','A');
