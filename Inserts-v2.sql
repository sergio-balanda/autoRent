USE autorent;

/*
SELECT * FROM reserva;
SELECT * FROM vehiculo;
SELECT * FROM usuario;
SELECT * FROM sucursal;
SELECT * FROM accesorio;
*/

INSERT INTO Usuario(administrador, nombre, email, password, cuit, puntos) VALUES
(TRUE, 'Pepe Duarte', 'admin@mail.com', 'admin', '433221100', 0),
(TRUE, 'Fabian Solis', 'a@mail.com', 1, '46237709', 0),
(FALSE, 'Esteban Silva', 'b@mail.com', 1, '46235700', 1000),
(FALSE, 'Krause Sebastian', 'sebakrause@gmail.com', '1234', '123456789', 0),
(FALSE, 'Sarkozy Samantha', 'ssarkozy@gmail.com', '1234', '987654321', 0),
(FALSE, 'Echevarria Joaquin', 'jo.eche15@gmail.com', '1234', '001122334', 0),
(FALSE, 'Raul Ramirez', 'c@mail.com', 1, '46235700', 35000);

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
('JK000LM', 'Volkswagen', 'Up', 'img/up.jpg', 4, 2, 0, 2, 5),
('KL123MN', 'Toyota', 'Corolla', 'img/corolla.jpg', 5, 3, 0, 1, 3),
('LM234NO', 'Toyota', 'Corolla', 'img/corolla.jpg', 5, 3, 0, 1, 3),
('MN345OP', 'Peugeot', '206 SW', 'img/206SW.jpg', 5, 2, 0, 2, 4),
('NO456PQ', 'Peugeot', '206 SW', 'img/206SW.jpg', 5, 2, 0, 2, 4);

INSERT INTO Reserva (fkVehiculoR, fkSucursalR, fechaInicio, fechaFin, costoOrigen,finalizada,id_usuario) VALUES
(9, 1, '2018-01-01 09:00:00', '2018-01-01 19:00:00', 85.00,false,3), 
(5, 1, '2018-02-01 09:00:00', '2018-02-06 09:00:00', 10399.20,false,2),
(6, 3, '2018-03-01 09:00:00', '2018-03-02 09:00:00', 2079.84,false,1),
(1, 4, '2018-04-01 09:00:00', '2018-04-01 10:00:00', 125.42,false,2),
(3, 3, '2018-05-01 09:00:00', '2018-05-11 09:00:00', 23496.00,false,2);

INSERT INTO Accesorio (nombre, costoDia , imagen) VALUES
('Ninguno', 00.00, ' '),
('GPS', 75.00,'img/gps.jpg'),
('Telepeaje', 100.00,'img/telepeaje.jpg'),
('Porta equipaje', 50.00,'img/portaeq.jpg'),
('Carro para valijas', 50.00,'img/carro.jpg'),
('Transporte al aeropuerto', 100.00,'img/taxi.jpg');