CREATE TABLE IF NOT EXISTS USUARIO (
  ID_Usuario serial,
  nombre varchar(50) DEFAULT NULL,
  PRIMARY KEY (ID_Usuario)
) ;

CREATE TABLE IF NOT EXISTS AMIGO (
  ID_Amigo serial,
  AmigoFk1 int ,
  AmigoFk2 int ,
  PRIMARY KEY (ID_Amigo),
  
  FOREIGN KEY (AmigoFk1) REFERENCES USUARIO (ID_Usuario),
  FOREIGN KEY (AmigoFk2) REFERENCES USUARIO (ID_Usuario)
);

CREATE TABLE IF NOT EXISTS PARCHE (
  ID_Parche serial,
  clave varchar(50) DEFAULT NULL,
  nombre varchar(50) DEFAULT NULL,
  descripcion text DEFAULT NULL,
  valorObjetivo Double ,
  monto Double ,
  estado BOOL,
  PRIMARY KEY (ID_Parche)
) ;

CREATE TABLE IF NOT EXISTS GRUPO (
  ID_Grupo serial,
  UsuarioFk int ,
  ParcheFk int ,
  PRIMARY KEY (ID_Grupo),
  
  FOREIGN KEY (UsuarioFk) REFERENCES USUARIO (ID_Usuario),
  FOREIGN KEY (ParcheFk) REFERENCES PARCHE (ID_Parche)
);

CREATE TABLE IF NOT EXISTS BILLETERA (
  ID_Billetera serialT,
  monto Double ,
  UsuarioFk int ,
  PRIMARY KEY (ID_Billetera),

  FOREIGN KEY (UsuarioFk) REFERENCES USUARIO (ID_Usuario)
);

CREATE TABLE IF NOT EXISTS TRANSFERENCIA (
  ID_Transferencia serial,
  monto Double,
  billeteraOFK int ,
  billeteraDFK int ,
  parcheOFk int ,
  parcheDFk int ,
  PRIMARY KEY (ID_Transferencia),
  
  FOREIGN KEY (billeteraOFK) REFERENCES BILLETERA (ID_Billetera),
  FOREIGN KEY (billeteraDFK) REFERENCES BILLETERA (ID_Billetera),
  FOREIGN KEY (parcheOFk) REFERENCES PARCHE (ID_Parche),
  FOREIGN KEY (parcheDFk) REFERENCES PARCHE (ID_Parche)
);

INSERT INTO usuario (nombre) VALUES ('Mario');
INSERT INTO usuario (nombre) VALUES ('Camila');
INSERT INTO usuario (nombre) VALUES ('Luisa');
INSERT INTO usuario (nombre) VALUES ('Laura');

INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('1', '2');
INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('1', '3');
INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('1', '4');
INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('2', '1');
INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('3', '1');
INSERT INTO amigo (AmigoFk1, AmigoFk2) VALUES ('4', '1');

INSERT INTO parche (clave, nombre, descripcion, valorObjetivo, monto, estado) VALUES ('1223', 'Polar', 'xctfvg', '200', '200', '1');
INSERT INTO parche (clave, nombre, descripcion, valorObjetivo, monto, estado) VALUES ('4321', 'Vengador', 'xctfvg', '400', '0', '0');

INSERT INTO grupo (UsuarioFk, ParcheFk) VALUES ('1', '1');
INSERT INTO grupo (UsuarioFk, ParcheFk) VALUES ('2', '1');
INSERT INTO grupo (UsuarioFk, ParcheFk) VALUES ('3', '1');
INSERT INTO grupo (UsuarioFk, ParcheFk) VALUES ('4', '1');

INSERT INTO billetera (monto, UsuarioFk) VALUES ('100', '1');
INSERT INTO billetera (monto, UsuarioFk) VALUES ('90', '2');
INSERT INTO billetera (monto, UsuarioFk) VALUES ('80', '3');
INSERT INTO billetera (monto, UsuarioFk) VALUES ('70', '4');

INSERT INTO transferencia (monto, billeteraOFK, parcheDFk) VALUES ('50', '1', '1');
INSERT INTO transferencia (monto, billeteraOFK, parcheDFk) VALUES ('50', '2', '1');
INSERT INTO transferencia (monto, billeteraOFK, parcheDFk) VALUES ('50', '3', '1');
INSERT INTO transferencia (monto, billeteraOFK, parcheDFk) VALUES ('50', '4', '1');
