/*
Created: 5/9/2021
Modified: 7/9/2021
Model: Oracle 18c
Database: Oracle 18c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE ctrl_empleado_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE ctrl_registro_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table ctrl_empleado

CREATE TABLE ctrl_empleado(
  emp_id Integer NOT NULL,
  em_nombre Varchar2(30 ) NOT NULL,
  emp_apellido Varchar2(30 ) NOT NULL,
  emp_cedula Varchar2(30 ) NOT NULL,
  emp_foto Blob NOT NULL,
  emp_folio Varchar2(30 ) NOT NULL,
  emp_nacimiento Date NOT NULL,
  emp_rol Varchar2(1 ) NOT NULL,
  emp_contra Varchar2(50 ),
  CONSTRAINT ctrl_empleado_ck01 CHECK (emp_rol in ('A','E'))
)
;

-- Add keys for table ctrl_empleado

ALTER TABLE ctrl_empleado ADD CONSTRAINT PK_ctrl_empleado PRIMARY KEY (emp_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_empleado.emp_id IS 'id del empleado'
;
COMMENT ON COLUMN ctrl_empleado.em_nombre IS 'Nombre del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_apellido IS 'Apellido del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_cedula IS 'Cedula del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_foto IS 'Foto del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_folio IS 'Folio del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_nacimiento IS 'Nacimiento del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_rol IS 'Rol del empleado
A= Admin
E=Empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_contra IS 'Contra por si es admin'
;

-- Table ctrl_registro

CREATE TABLE ctrl_registro(
  reg_id Integer NOT NULL,
  emp_id Integer NOT NULL,
  reg_entrada Date,
  reg_salida Date,
  reg_completado Varchar2(1 ),
  CONSTRAINT ctrl_registro_ck01 CHECK (reg_completado in ('C','I'))
)
;

-- Create indexes for table ctrl_registro

CREATE INDEX IX_Relationship1 ON ctrl_registro (emp_id)
;

-- Add keys for table ctrl_registro

ALTER TABLE ctrl_registro ADD CONSTRAINT PK_ctrl_registro PRIMARY KEY (reg_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_registro.reg_id IS 'Id del registro'
;
COMMENT ON COLUMN ctrl_registro.reg_entrada IS 'Entrada al trabajo'
;
COMMENT ON COLUMN ctrl_registro.reg_salida IS 'Salida del trabajo'
;
COMMENT ON COLUMN ctrl_registro.reg_completado IS 'C= Completado
I= Incompleto'
;

-- Trigger for sequence ctrl_empleado_seq01 for column emp_id in table ctrl_empleado ---------
CREATE OR REPLACE TRIGGER ctrl_empleado_tgr01 BEFORE INSERT
ON ctrl_empleado FOR EACH ROW
BEGIN
  IF :new.emp_id IS NULL OR :new.emp_id <=1 THEN
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

-- Trigger for sequence ctrl_registro_seq01 for column reg_id in table ctrl_registro ---------
CREATE OR REPLACE TRIGGER ctrl_registro_tgr01 BEFORE INSERT
ON ctrl_registro FOR EACH ROW
BEGIN
  IF :new.reg_id IS NULL OR :new.reg_id <=1 THEN
  :new.reg_id := ctrl_registro_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_registro_tgr02 AFTER UPDATE OF reg_id
ON ctrl_registro FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column reg_id in table ctrl_registro as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE ctrl_registro ADD CONSTRAINT ctrl_registro_fk01 FOREIGN KEY (emp_id) REFERENCES ctrl_empleado (emp_id)
;





