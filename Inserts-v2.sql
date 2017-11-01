USE autorent;

INSERT INTO Sucursal (ciudad, provincia, domicilio) VALUES
('Capital Federal', 'Buenos Aires', 'Jose Bonifacio 846'),
('Bariloche', 'Rio Negro', 'Rafael Obligado 120'),
('Cordoba', 'Cordoba', 'Alonso de Ubeda 433'),
('Iguazu', 'Misiones', 'Aeropuerto'),
('Rio Grande', 'Tierra del Fuego', 'Aeropuerto');

INSERT INTO Vehiculo (patente, marca, nombre ,imagen, capacidadPasajeros, capacidadValijas, kilometraje, fkSucursalV) VALUES
('AB111CD', 'Toyota', 'Hilux', 'img/hilux.jpg', 5, 6, 0, 4),
('BC222DE', 'Ford', 'Ranger', 'img/ranger.jpg', 5, 5, 0, 2),
('CD333EF', 'Chevrolet', 'Spin', 'img/spin.jpg', 7, 3, 0, 3),
('DE444FG', 'Mercedes Benz', 'Vito', 'img/vito.jpg', 8, 2, 0, 1),
('EF555GH', 'Toyota', 'Corolla', 'img/corolla.jpg', 5, 3, 0, 1),
('FG666HI', 'Volkswagen', 'Vento', 'img/vento.jpg', 5, 2, 0, 3),
('GH777IJ', 'Citroen', 'C4', 'img/c4.jpg', 5, 2, 0, 3),
('HI888JK', 'Peugeot', '206 SW', 'img/206SW.jpg', 5, 2, 0, 2),
('IJ999KL', 'Fortwo', 'Fortwo', 'img/fortwo.jpg', 2, 1, 0, 1),
('JK000LM', 'Volkswagen', 'Up', 'img/up.jpg', 4, 2, 0, 2);


INSERT INTO Reserva (fkVehiculo, fkSucursalR, fechaInicio, fechaFin, costoOrigen) VALUES
(9, 1, '2018-01-01 09:00:00', '2018-01-01 19:00:00', 455.00), 
(5, 1, '2018-02-01 09:00:00', '2018-02-06 09:00:00', 10399.20),
(6, 3, '2018-03-01 09:00:00', '2018-03-02 09:00:00', 2079.84),
(1, 4, '2018-04-01 09:00:00', '2018-04-01 10:00:00', 125.42),
(3, 3, '2018-05-01 09:00:00', '2018-05-11 09:00:00', 23496.00);


