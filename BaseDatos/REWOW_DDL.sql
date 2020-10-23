-- Generado por Oracle SQL Developer Data Modeler 20.2.0.167.1538
--   en:        2020-10-21 19:39:43 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE dueno (
    dueno_id         NUMBER(6) NOT NULL,
    dueno_nombre     VARCHAR2(100) NOT NULL,
    dueno_telefono   VARCHAR2(20),
    dueno_direccion  VARCHAR2(200)
);

ALTER TABLE dueno ADD CONSTRAINT dueno_pk PRIMARY KEY ( dueno_id );

CREATE TABLE mascota (
    mascota_id      NUMBER(6) NOT NULL,
    mascota_nombre  VARCHAR2(50) NOT NULL
);

ALTER TABLE mascota ADD CONSTRAINT mascota_pk PRIMARY KEY ( mascota_id );

CREATE TABLE reg_medico (
    reg_medico_id               NUMBER(6) NOT NULL,
    reg_medico_dueno_id         NUMBER(6) NOT NULL,
    reg_medico_mascota_id       NUMBER(6) NOT NULL,
    reg_medico_tipo_mascota_id  NUMBER(6) NOT NULL,
    reg_medico_tamano           CHAR(1),
    reg_medico_desc             VARCHAR2(500)
);

ALTER TABLE reg_medico ADD CONSTRAINT registro_medico_pk PRIMARY KEY ( reg_medico_id );

CREATE TABLE tipo_mascosta (
    tipo_mascota_id      NUMBER(6) NOT NULL,
    tipo_mascota_desc    VARCHAR2(50),
    tipo_mascota_estado  CHAR(1) NOT NULL
);

ALTER TABLE tipo_mascosta ADD CONSTRAINT tipo_mascosta_pk PRIMARY KEY ( tipo_mascota_id );

CREATE TABLE tipo_vacuna (
    tipo_vacuna_id    NUMBER(6) NOT NULL,
    tipo_vacuna_desc  VARCHAR2(50) NOT NULL
);

ALTER TABLE tipo_vacuna ADD CONSTRAINT tipo_vacuna_pk PRIMARY KEY ( tipo_vacuna_id );

CREATE TABLE vacregmed (
    vacregmed_id         NUMBER(6) NOT NULL,
    vacregmed_vacuna_id  NUMBER(6) NOT NULL,
    vacregmed_regmed_id  NUMBER(6) NOT NULL
);

ALTER TABLE vacregmed ADD CONSTRAINT vac_reg_medico_pk PRIMARY KEY ( vacregmed_id );

CREATE TABLE vacuna (
    vacuna_id              NUMBER(6) NOT NULL,
    vacuna_numero          VARCHAR2(10) NOT NULL,
    vacuna_tipo_vacuna_id  NUMBER(6) NOT NULL,
    vacuna_fecha           DATE
);

ALTER TABLE vacuna ADD CONSTRAINT vacunas_pk PRIMARY KEY ( vacuna_id );

ALTER TABLE reg_medico
    ADD CONSTRAINT reg_medico_dueno_fk FOREIGN KEY ( reg_medico_dueno_id )
        REFERENCES dueno ( dueno_id );

ALTER TABLE reg_medico
    ADD CONSTRAINT reg_medico_mascota_fk FOREIGN KEY ( reg_medico_mascota_id )
        REFERENCES mascota ( mascota_id );

ALTER TABLE reg_medico
    ADD CONSTRAINT reg_medico_tipo_mascosta_fk FOREIGN KEY ( reg_medico_tipo_mascota_id )
        REFERENCES tipo_mascosta ( tipo_mascota_id );

ALTER TABLE vacregmed
    ADD CONSTRAINT vacregmed_reg_medico_fk FOREIGN KEY ( vacregmed_regmed_id )
        REFERENCES reg_medico ( reg_medico_id );

ALTER TABLE vacregmed
    ADD CONSTRAINT vacregmed_vacuna_fk FOREIGN KEY ( vacregmed_vacuna_id )
        REFERENCES vacuna ( vacuna_id );

ALTER TABLE vacuna
    ADD CONSTRAINT vacuna_tipo_vacuna_fk FOREIGN KEY ( vacuna_tipo_vacuna_id )
        REFERENCES tipo_vacuna ( tipo_vacuna_id );

create sequence sec_dueno
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;

create sequence sec_mascota
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence sec_regmed
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;




