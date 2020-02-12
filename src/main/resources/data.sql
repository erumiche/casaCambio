/*CREATE TABLE moneda (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(10) NOT NULL,
  descripcion VARCHAR(250) NOT NULL
);*/

insert into moneda (nombre, descripcion) values
('PEN', 'Nuevos soles'),
('USD', 'Dolar'),
('EUR', 'Euro');

/*
CREATE TABLE tipo_cambio (
  id INT AUTO_INCREMENT PRIMARY KEY,
  moneda_origen NUMBER NOT NULL,
  moneda_destino NUMBER NOT NULL,
  tipo_cambio NUMBER NOT NULL
);
*/
insert into tipo_cambio (moneda_origen,moneda_destino, tipo_cambio)
values(1, 2, 3.4);

insert into tipo_cambio (moneda_origen,moneda_destino, tipo_cambio)
values(2, 1, 0.29);

insert into tipo_cambio (moneda_origen,moneda_destino, tipo_cambio)
values(1, 3, 3.71);

insert into tipo_cambio (moneda_origen,moneda_destino, tipo_cambio)
values(3, 1, 0.27);