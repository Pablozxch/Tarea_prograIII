/*
Created: 5/9/2021
Modified: 5/9/2021
Model: Oracle 18c
Database: Oracle 18c
*/


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

CREATE SEQUENCE ctrl_rol_seq01
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

CREATE SEQUENCE ctrl_registro_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table ctrl_persona

CREATE TABLE ctrl_persona(
  per_id Integer NOT NULL,
  per_nombre Varchar2(30 ) NOT NULL,
  per_apellido Varchar2(30 ) NOT NULL,
  per_cedula Varchar2(30 ) NOT NULL,
  per_foto Blob NOT NULL,
  per_nacimiento Date NOT NULL
)
;

-- Add keys for table ctrl_persona

ALTER TABLE ctrl_persona ADD CONSTRAINT PK_ctrl_persona PRIMARY KEY (per_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_persona.per_id IS 'id de la persona'
;
COMMENT ON COLUMN ctrl_persona.per_nombre IS 'Nombre de la persona'
;
COMMENT ON COLUMN ctrl_persona.per_apellido IS 'Apellido de la persona'
;
COMMENT ON COLUMN ctrl_persona.per_cedula IS 'Cedula de la persona'
;
COMMENT ON COLUMN ctrl_persona.per_foto IS 'Foto de la persona'
;
COMMENT ON COLUMN ctrl_persona.per_nacimiento IS 'Nacimiento de la persona'
;

-- Table ctrl_empleado

CREATE TABLE ctrl_empleado(
  emp_id Integer NOT NULL,
  emp_horastrabajadas Integer,
  per_id Integer
)
;

-- Create indexes for table ctrl_empleado

CREATE INDEX IX_Relationship2 ON ctrl_empleado (per_id)
;

-- Add keys for table ctrl_empleado

ALTER TABLE ctrl_empleado ADD CONSTRAINT PK_ctrl_empleado PRIMARY KEY (emp_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_empleado.emp_id IS 'id del empleado'
;
COMMENT ON COLUMN ctrl_empleado.emp_horastrabajadas IS 'Llevar conteo de hroas trabajadas'
;

-- Table ctrl_rol

CREATE TABLE ctrl_rol(
  rol_id Integer NOT NULL,
  rol_contra Varchar2(30 ) NOT NULL,
  emp_id Integer NOT NULL
)
;

-- Create indexes for table ctrl_rol

CREATE INDEX IX_Relationship3 ON ctrl_rol (emp_id)
;

-- Add keys for table ctrl_rol

ALTER TABLE ctrl_rol ADD CONSTRAINT PK_ctrl_rol PRIMARY KEY (rol_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_rol.rol_id IS 'Id del rol'
;
COMMENT ON COLUMN ctrl_rol.rol_contra IS 'Contra del admin'
;

-- Table ctrl_historial

CREATE TABLE ctrl_historial(
  his_id Integer NOT NULL,
  emp_id Integer NOT NULL
)
;

-- Create indexes for table ctrl_historial

CREATE INDEX IX_Relationship4 ON ctrl_historial (emp_id)
;

-- Add keys for table ctrl_historial

ALTER TABLE ctrl_historial ADD CONSTRAINT PK_ctrl_historial PRIMARY KEY (his_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN ctrl_historial.his_id IS 'Id del historial'
;

-- Table ctrl_registro

CREATE TABLE ctrl_registro(
  reg_id Integer NOT NULL,
  reg_entrada Date,
  reg_salida Date,
  reg_completado Varchar2(1 ),
  his_id Integer NOT NULL,
  CONSTRAINT ctrl_registrock01 CHECK (reg_completado in ('C','I'))
)
;

-- Create indexes for table ctrl_registro

CREATE INDEX IX_Relationship5 ON ctrl_registro (his_id)
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

-- Trigger for sequence ctrl_persona_seq01 for column per_id in table ctrl_persona ---------
CREATE OR REPLACE TRIGGER ctrl_persona_tgr01 BEFORE INSERT
ON ctrl_persona FOR EACH ROW
BEGIN
 IF :new.per_id IS NULL OR :new.per_id>1
  :new.per_id := ctrl_persona_seq01.nextval; 
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ctrl_persona_tgr02 AFTER UPDATE OF per_id
ON ctrl_persona FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column per_id in table ctrl_persona as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_empleado_seq01 for column emp_id in table ctrl_empleado ---------
CREATE OR REPLACE TRIGGER ctrl_empleado_tgr01 BEFORE INSERT
ON ctrl_empleado FOR EACH ROW
BEGIN
  IF :new.emp_id IS NULL OR :new.emp_id>1
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

-- Trigger for sequence ctrl_rol_seq01 for column rol_id in table ctrl_rol ---------
CREATE OR REPLACE TRIGGER ts_ctrl_rol_tgr01 BEFORE INSERT
ON ctrl_rol FOR EACH ROW
BEGIN
  IF :new.rol_id IS NULL OR :new.rol_id>1
  :new.rol_id := ctrl_rol_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER ts_ctrl_rol_tgr02 AFTER UPDATE OF rol_id
ON ctrl_rol FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column rol_id in table ctrl_rol as it uses sequence.');
END;
/

-- Trigger for sequence ctrl_historial_seq01 for column his_id in table ctrl_historial ---------
CREATE OR REPLACE TRIGGER ctrl_historial_tgr01 BEFORE INSERT
ON ctrl_historial FOR EACH ROW
BEGIN
  IF :new.his_id IS NULL OR :new.his_id>1
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

-- Trigger for sequence ctrl_registro_seq01 for column reg_id in table ctrl_registro ---------
CREATE OR REPLACE TRIGGER ctrl_registro_tgr01 BEFORE INSERT
ON ctrl_registro FOR EACH ROW
BEGIN
  IF :new.reg_id IS NULL OR :new.reg_id>1
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

ALTER TABLE ctrl_empleado ADD CONSTRAINT ctrl_empleados_fk01 FOREIGN KEY (per_id) REFERENCES ctrl_persona (per_id)
;



ALTER TABLE ctrl_rol ADD CONSTRAINT ctrl_rol_fk01 FOREIGN KEY (emp_id) REFERENCES ctrl_empleado (emp_id)
;



ALTER TABLE ctrl_historial ADD CONSTRAINT ctrl_historial_fk01 FOREIGN KEY (emp_id) REFERENCES ctrl_empleado (emp_id)
;



ALTER TABLE ctrl_registro ADD CONSTRAINT ctrl_registro_fk01 FOREIGN KEY (his_id) REFERENCES ctrl_historial (his_id)
;





