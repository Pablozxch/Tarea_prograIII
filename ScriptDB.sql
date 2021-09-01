/*
Created: 27/8/2021
Modified: 31/8/2021
Model: Oracle 18c
Database: Oracle 18c
*/


-- Drop relationships section -------------------------------------------------

ALTER TABLE ctrl_dias DROP CONSTRAINT ctrl_dias_fk01
;
ALTER TABLE ctrl_semanas DROP CONSTRAINT ctrl_semanas_fk01
;
ALTER TABLE ctrl_historial DROP CONSTRAINT ctrl_historial_fk01
;
ALTER TABLE ctrl_empleado DROP CONSTRAINT ctrl_empleado_fk01
;




-- Drop keys for tables section -------------------------------------------------

ALTER TABLE ctrl_dias DROP CONSTRAINT PK_ctrl_dias
;
ALTER TABLE ctrl_semanas DROP CONSTRAINT PK_ctrl_semanas
;
ALTER TABLE ctrl_historial DROP CONSTRAINT PK_ctrl_historial
;
ALTER TABLE ctrl_empleado DROP CONSTRAINT PK_ctrl_empleado
;
ALTER TABLE ctrl_persona DROP CONSTRAINT PK_ctrl_persona
;


-- Drop indexes section -------------------------------------------------

DROP INDEX trl_dias_fk01
;
DROP INDEX ctrl_semanas_fk01
;
DROP INDEX ctrl_historial_fk01
;
DROP INDEX ctrl_empleado_fk01
;


-- Drop tables section ---------------------------------------------------

DROP TABLE ctrl_dias
;
DROP TABLE ctrl_semanas
;
DROP TABLE ctrl_historial
;
DROP TABLE ctrl_empleado
;
DROP TABLE ctrl_persona
;

-- Drop sequences section --------------------------------------------------- 

DROP SEQUENCE ctrl_dias_seq01
;
DROP SEQUENCE ctrl_semanas_seq01
;
DROP SEQUENCE ctrl_historial_seq01
;
DROP SEQUENCE ctrl_empleado_seq01
;
DROP SEQUENCE ctrl_persona_seq01
;

-- Create sequences section -------------------------------------------------

CREATE SEQUENCE ctrl_persona_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE ctrl_empleado_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE ctrl_historial_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE ctrl_semanas_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE ctrl_dias_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table ctrl_persona

CREATE TABLE ctrl_persona(
  prs_id Integer NOT NULL,
  prs_nombre Varchar2(50 ) NOT NULL,
  prs_apellido Varchar2(50 ) NOT NULL,
  prs_cedula Number NOT NULL,
  prs_fechanacimiento Date NOT NULL,
  prs_foto Blob NOT NULL
)
;

-- Add keys for table ctrl_persona

ALTER TABLE ctrl_persona ADD CONSTRAINT PK_ctrl_persona PRIMARY KEY (prs_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_persona.prs_id IS 'Id de la persona  '
;
COMMENT ON COLUMN ctrl_persona.prs_nombre IS 'Nombre de la persona'
;
COMMENT ON COLUMN ctrl_persona.prs_apellido IS 'Apellido de la persona '
;
COMMENT ON COLUMN ctrl_persona.prs_cedula IS 'Cedula de la persona'
;
COMMENT ON COLUMN ctrl_persona.prs_fechanacimiento IS 'Fecha de nacimiento 
'
;
COMMENT ON COLUMN ctrl_persona.prs_foto IS 'Foto de la persona
'
;

-- Table ctrl_empleado

CREATE TABLE ctrl_empleado(
  emp_id Integer NOT NULL,
  prs_id Integer NOT NULL,
  emp_admin Varchar2(1 ),
  emp_contra Varchar2(30 ),
  CONSTRAINT empleado_ck01 CHECK (emp_admin in ('A','E'))
)
;

-- Create indexes for table ctrl_empleado

CREATE INDEX ctrl_empleado_fk01 ON ctrl_empleado (prs_id)
;

-- Add keys for table ctrl_empleado

ALTER TABLE ctrl_empleado ADD CONSTRAINT PK_ctrl_empleado PRIMARY KEY (emp_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_empleado.emp_id IS 'Id del empleado'
;
COMMENT ON COLUMN ctrl_empleado.prs_id IS 'Id de la persona'
;
COMMENT ON COLUMN ctrl_empleado.emp_admin IS 'A para admin
E para empleado
'
;
COMMENT ON COLUMN ctrl_empleado.emp_contra IS 'Contra del usuario'
;

-- Table ctrl_historial

CREATE TABLE ctrl_historial(
  his_id Integer NOT NULL,
  emp_id Integer
)
;

-- Create indexes for table ctrl_historial

CREATE INDEX ctrl_historial_fk01 ON ctrl_historial (emp_id)
;

-- Add keys for table ctrl_historial

ALTER TABLE ctrl_historial ADD CONSTRAINT PK_ctrl_historial PRIMARY KEY (his_id)
;

-- Table ctrl_semanas

CREATE TABLE ctrl_semanas(
  sem_id Integer NOT NULL,
  his_id Integer
)
;

-- Create indexes for table ctrl_semanas

CREATE INDEX ctrl_semanas_fk01 ON ctrl_semanas (his_id)
;

-- Add keys for table ctrl_semanas

ALTER TABLE ctrl_semanas ADD CONSTRAINT PK_ctrl_semanas PRIMARY KEY (sem_id)
;

-- Table ctrl_dias

CREATE TABLE ctrl_dias(
  dia_id Integer NOT NULL,
  sem_id Integer NOT NULL,
  dia_fechaingreso Date NOT NULL,
  dia_fechasalida Date NOT NULL,
  dia_completado Varchar2(1 ) NOT NULL,
  CONSTRAINT ctrl_dia_completado_ck01 CHECK (dia_completado in ('C','I'))
)
;

-- Create indexes for table ctrl_dias

CREATE INDEX trl_dias_fk01 ON ctrl_dias (sem_id)
;

-- Add keys for table ctrl_dias

ALTER TABLE ctrl_dias ADD CONSTRAINT PK_ctrl_dias PRIMARY KEY (dia_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_dias.dia_id IS 'Id del dia de la semana'
;
COMMENT ON COLUMN ctrl_dias.sem_id IS 'Id de la semana'
;
COMMENT ON COLUMN ctrl_dias.dia_fechaingreso IS 'Fecha de ingreso al trabajo'
;
COMMENT ON COLUMN ctrl_dias.dia_fechasalida IS 'Fecha de salido del trabajo'
;
COMMENT ON COLUMN ctrl_dias.dia_completado IS 'Dia completado
S para Sii
N para No'
;

-- Trigger for sequence ctrl_persona_seq01 for column prs_id in table ctrl_persona ---------
CREATE OR REPLACE TRIGGER ctrl_persona_tgr01 BEFORE INSERT
ON ctrl_persona FOR EACH ROW
BEGIN
  IF :new.prs_id IS NULL OR :new.prs_id < 1 THEN
  :new.prs_id := ctrl_persona_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_persona_tgr02 AFTER UPDATE OF prs_id
ON ctrl_persona FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column prs_id in table ctrl_persona as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_empleado_seq01 for column emp_id in table ctrl_empleado ---------
CREATE OR REPLACE TRIGGER ctrl_empleado_tgr01 BEFORE INSERT
ON ctrl_empleado FOR EACH ROW
BEGIN
  IF :new.emp_id IS NULL OR :new.emp_id <1 THEN
  :new.emp_id := ctrl_empleado_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_empleado_tgr02 AFTER UPDATE OF emp_id
ON ctrl_empleado FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column emp_id in table ctrl_empleado as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_historial_seq01 for column his_id in table ctrl_historial ---------
CREATE OR REPLACE TRIGGER ctrl_historial_tgr01 BEFORE INSERT
ON ctrl_historial FOR EACH ROW
BEGIN
  IF :new.his_id IS NULL OR :new.his_id < 1 THEN
  :new.his_id := ctrl_historial_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_historial_tgr02 AFTER UPDATE OF his_id
ON ctrl_historial FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column his_id in table ctrl_historial as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_semanas_seq01 for column sem_id in table ctrl_semanas ---------
CREATE OR REPLACE TRIGGER ctrl_semanas_tgr01 BEFORE INSERT
ON ctrl_semanas FOR EACH ROW
BEGIN
  IF :new.sem_id IS NULL OR :new.sem_id < 1 THEN
  :new.sem_id := ctrl_semanas_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_semanas_tgr02 AFTER UPDATE OF sem_id
ON ctrl_semanas FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column sem_id in table ctrl_semanas as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_dias_seq01 for column dia_id in table ctrl_dias ---------
CREATE OR REPLACE TRIGGER ctrl_dias_tgr01 BEFORE INSERT
ON ctrl_dias FOR EACH ROW
BEGIN
  IF :new.dia_id IS NULL OR :new.dia_id <1 THEN
  :new.dia_id := ctrl_dias_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_dias_tgr02 AFTER UPDATE OF dia_id
ON ctrl_dias FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column dia_id in table ctrl_dias as it uses sequence.');
END;
/

-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE ctrl_empleado ADD CONSTRAINT ctrl_empleado_fk01 FOREIGN KEY (prs_id) REFERENCES ctrl_persona (prs_id)
;



ALTER TABLE ctrl_historial ADD CONSTRAINT ctrl_historial_fk01 FOREIGN KEY (emp_id) REFERENCES ctrl_empleado (emp_id)
;



ALTER TABLE ctrl_semanas ADD CONSTRAINT ctrl_semanas_fk01 FOREIGN KEY (his_id) REFERENCES ctrl_historial (his_id)
;



ALTER TABLE ctrl_dias ADD CONSTRAINT ctrl_dias_fk01 FOREIGN KEY (sem_id) REFERENCES ctrl_semanas (sem_id)
;





