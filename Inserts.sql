USE autorent;

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
('AB111CD', 'Toyota', 'Hilux', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 5, 6, 0, 4, 1),
('BC222DE', 'Ford', 'Ranger', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 5, 5, 0, 2, 1),
('CD333EF', 'Chevrolet', 'Spin', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 7, 3, 0, 3, 2),
('DE444FG', 'Mercedes Benz', 'Vito', 'http://www.worldfranchisebusiness.com/wp-content/uploads/2011/09/mercedes-benz-vito-taxi.png', 8, 2, 0, 1, 2),
('EF555GH', 'Toyota', 'Corolla', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 5, 3, 0, 1, 3),
('FG666HI', 'Volkswagen', 'Vento', 'https://www.autodato.com/wp-content/uploads/2013/02/Volkswagen-Vento-Argentina-Xenon-LED-2014.png', 5, 2, 0, 3, 3),
('GH777IJ', 'Citroen', 'C4', 'https://info.citroen.co.uk/Assets/uploads/offers/individual-offers/slider/318-c4-picasso-front.png', 5, 2, 0, 3, 4),
('HI888JK', 'Peugeot', '206 SW', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 5, 2, 0, 2, 4),
('IJ999KL', 'Fortwo', 'Fortwo', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 2, 1, 0, 1, 5),
('JK000LM', 'Volkswagen', 'Up', 'http://soundinmotion.com.au/wp-content/uploads/2016/08/sr5-.png', 4, 2, 0, 2, 5);

INSERT INTO Servicio (nombre, costoPorcentual) VALUES
('Ninguno', 00.00),
('Asistencia mecanica', 20.00),
('Tanque lleno', 10.00),
('Entrega fuera de hora', 15.00),
('Entrega en otra sucursal', 15.00),
('Kilometraje ilimitado', 20.00);

INSERT INTO Accesorio (nombre, costoDia) VALUES
('Ninguno', 00.00),
('GPS', 75.00),
('Telepeaje', 100.00),
('Porta equipaje', 50.00),
('Carro para valijas', 50.00),
('Transporte al aeropuerto', 100.00);

INSERT INTO Cliente (nombre, pasaporte, email, telefono, tarjeta, puntaje) VALUES
('Krause Sebastian', 'AA123456', 'sebakrause@gmail.com', '541112345678', '1234123412341234', 0),
('Sarkozy Samantha', 'AA111111', 'ssarkozy@gmail.com', '541199999999', '1111222233334444', 0),
('Echevarria Joaquin', 'AA222222', 'jo.eche15@gmail.com', '541188888888', '9999888877776666', 0),
('Ackermann Matias', 'AA333333', 'ackermanm1@gmail.com', '541177777777', '0000222244446666', 0),
('Corna Gabriela', 'AA444444', 'gabrielacorna99@gmail.com', '541166666666', '3333555577779999', 0);

INSERT INTO Reserva (fkClienteR, fkVehiculoR, fkSucursalR, fechaInicio, fechaFin, costoOrigen) VALUES
(1, 9, 1, '2018-01-01 09:00:00', '2018-01-01 19:00:00', 455.00), 
(1, 5, 1, '2018-02-01 09:00:00', '2018-02-06 09:00:00', 10399.20),
(2, 6, 3, '2018-03-01 09:00:00', '2018-03-02 09:00:00', 2079.84),
(4, 1, 4, '2018-04-01 09:00:00', '2018-04-01 10:00:00', 125.42),
(5, 3, 3, '2018-05-01 09:00:00', '2018-05-11 09:00:00', 23496.00);

INSERT INTO Alquiler (fkReservaA, fkServicioA, fkAccesorioA, costoTotal) VALUES 
(1, 1, 1, 455.00),
(2, 1, 1, 10399.20),
(3, 1, 1, 2079.84),
(4, 1, 1, 125.42),
(5, 1, 1, 23496.00);
