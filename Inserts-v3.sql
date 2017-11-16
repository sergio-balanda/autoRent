USE autorent;
/*select * from reserva;
select * from vehiculo;
select * from usuario;*/

insert into usuario(administrador,email,nombre,password,puntos) values (true,'a@mail.com','julio',1,100);
insert into usuario(administrador,email,nombre,password,puntos) values (false,'b@mail.com','esteban',1,500);


INSERT INTO Sucursal (ciudad, provincia, domicilio) VALUES
('Capital Federal', 'Buenos Aires', 'Jose Bonifacio 846'),
('Bariloche', 'Rio Negro', 'Rafael Obligado 120'),
('Cordoba', 'Cordoba', 'Alonso de Ubeda 433'),
('Iguazu', 'Misiones', 'Aeropuerto'),
('Rio Grande', 'Tierra del Fuego', 'Aeropuerto');

INSERT INTO Categoria (nombre, costoHora) VALUES
('4x4', 125.42),
('Minivan', 97.90),
('Premium', 86.66),
('Grande', 77.75),
('Compacto', 45.50);

INSERT INTO Vehiculo (patente, marca, nombre ,imagen, capacidadPasajeros, capacidadValijas, kilometraje, fkSucursalV, fkCategoriaV) VALUES
('AB111CD', 'Toyota', 'Hilux', 'img/hilux.jpg', 5, 6, 0, 4, 1),
('BC222DE', 'Ford', 'Ranger', 'img/ranger.jpg', 5, 5, 0, 2, 1),
('CD333EF', 'Chevrolet', 'Spin', 'img/spin.jpg', 7, 3, 0, 3, 2),
('DE444FG', 'Mercedes Benz', 'Vito', 'img/vito.jpg', 8, 2, 0, 1, 2),
('EF555GH', 'Toyota', 'Corolla', 'img/corolla.jpg', 5, 3, 0, 1, 3),
('FG666HI', 'Volkswagen', 'Vento', 'img/vento.jpg', 5, 2, 0, 3, 3),
('GH777IJ', 'Citroen', 'C4', 'img/c4.jpg', 5, 2, 0, 3, 4),
('HI888JK', 'Peugeot', '206 SW', 'img/206SW.jpg', 5, 2, 0, 2, 4),
('IJ999KL', 'Fortwo', 'Fortwo', 'img/fortwo.jpg', 2, 1, 0, 1, 5),
('JK000LM', 'Volkswagen', 'Up', 'img/up.jpg', 4, 2, 0, 2, 5);


INSERT INTO Reserva (fkVehiculoR, fkSucursalR, fechaInicio, fechaFin, costoOrigen) VALUES
(9, 1, '2018-01-01 09:00:00', '2018-01-01 19:00:00', 455.00), 
(5, 1, '2018-02-01 09:00:00', '2018-02-06 09:00:00', 10399.20),
(6, 3, '2018-03-01 09:00:00', null, 2079.84),
(1, 4, '2018-04-01 09:00:00', null, 125.42),
(3, 3, '2018-05-01 09:00:00', null, 23496.00);





