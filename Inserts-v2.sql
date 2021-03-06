-- DROP DATABASE IF EXISTS autorent;
-- CREATE DATABASE IF NOT EXISTS autorent;
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

INSERT INTO Reserva (fkVehiculoR, fkSucursalR, fechaInicio, fechaFin, costoOrigen, id_usuario) VALUES
(8, 2, '2017-11-01 10:00:00', '2017-11-15 10:00:00', 1166.25, 3),
(3, 2, '2017-11-20 07:00:00', '2017-12-20 07:00:00', 2937.00, 4),
(4, 2, '2017-11-01 13:00:00', '2017-12-15 13:00:00', 4405.50, 6),
(9, 1, '2018-01-01 09:00:00', '2018-01-01 19:00:00', 45.50, 3), 
(5, 1, '2018-02-01 09:00:00', '2018-02-06 09:00:00', 433.33, 4),
(6, 3, '2018-03-01 09:00:00', '2018-03-02 09:00:00', 86.66, 5),
(1, 4, '2018-04-01 09:00:00', '2018-04-01 10:00:00', 125.42, 6),
(3, 3, '2018-05-01 09:00:00', '2018-05-11 09:00:00', 866.60, 7);

INSERT INTO Alquiler (fkReserva, finalizada, precioFinal) VALUES
(1, TRUE, 3791.25),
(2, TRUE, 2937.00),
(3, FALSE, 6655.50);

INSERT INTO Accesorio (nombre, costoDia , imagen) VALUES
('Ninguno', 00.00, ' '),
('GPS', 75.00, 'img/gps.jpg'),
('Telepeaje', 100.00, 'img/telepeaje.jpg'),
('Porta equipaje', 50.00, 'img/portaeq.jpg'),
('Asientos para bebes', 50.00, 'img/asientos-bebe.jpg'),
('Radio Satelital', 100.00, 'img/radio-satelital.jpg');

INSERT INTO AlquilerAccesorio (fkAlquiler, fkAccesorio) VALUES
(1, 2),
(1, 3),
(2, 1),
(3, 5);