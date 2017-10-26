DROP DATABASE IF EXISTS autorent;
CREATE DATABASE IF NOT EXISTS autorent;
USE autorent;

CREATE TABLE Sucursal (
    idSucursal INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ciudad NVARCHAR(20) NOT NULL,
    provincia NVARCHAR(20) NOT NULL,
    domicilio NVARCHAR(40) NOT NULL,
    PRIMARY KEY (idSucursal)
);

CREATE TABLE Categoria (
    idCategoria INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(20) NOT NULL,
    costoHora FLOAT(8, 2) UNSIGNED NOT NULL,
    PRIMARY KEY (idCategoria)
);

CREATE TABLE Vehiculo (
    idVehiculo INT UNSIGNED NOT NULL AUTO_INCREMENT,
    patente NVARCHAR(7) NOT NULL UNIQUE,
    marca NVARCHAR(20) NOT NULL,
    nombre NVARCHAR(20) NOT NULL,
    imagen varchar(255) NOT NULL,
    capacidadPasajeros TINYINT UNSIGNED NOT NULL,
    capacidadValijas TINYINT UNSIGNED NOT NULL,
    kilometraje MEDIUMINT UNSIGNED NOT NULL,
    fkSucursalV INT UNSIGNED NOT NULL,
    fkCategoriaV INT UNSIGNED NOT NULL,
    PRIMARY KEY (idVehiculo),
    CONSTRAINT fk_sucv FOREIGN KEY (fkSucursalV)
        REFERENCES Sucursal (idSucursal),
    CONSTRAINT fk_catv FOREIGN KEY (fkCategoriaV)
        REFERENCES Categoria (idCategoria)
);

CREATE TABLE Servicio (
    idServicio INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(50) NOT NULL,
    costoPorcentual FLOAT(8, 2) UNSIGNED NOT NULL,
    PRIMARY KEY (idServicio)
);

CREATE TABLE Accesorio (
    idAccesorio INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(50) NOT NULL,
    costoDia FLOAT(8, 2) UNSIGNED NOT NULL,
    PRIMARY KEY (idAccesorio)
);

CREATE TABLE Cliente (
    idCliente INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(50) NOT NULL,
    pasaporte NVARCHAR(8) NOT NULL,
    email NVARCHAR(40) NOT NULL,
    telefono NVARCHAR(20) NOT NULL,
    tarjeta NVARCHAR(16) NOT NULL,
    puntaje MEDIUMINT NOT NULL,
    PRIMARY KEY (idCliente)
);

CREATE TABLE Reserva (
    idReserva INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fkClienteR INT UNSIGNED NOT NULL,
    fkVehiculoR INT UNSIGNED NOT NULL,
    fkSucursalR INT UNSIGNED NOT NULL,
    fechaInicio DATETIME NOT NULL,
    fechaFin DATETIME NOT NULL,
    costoOrigen FLOAT(8, 2) UNSIGNED NOT NULL,
    PRIMARY KEY (idReserva),
    CONSTRAINT fk_clir FOREIGN KEY (fkClienteR)
        REFERENCES Cliente (idCliente),
    CONSTRAINT fk_vehr FOREIGN KEY (fkVehiculoR)
        REFERENCES Vehiculo (idVehiculo),
    CONSTRAINT fk_sucr FOREIGN KEY (fkSucursalR)
        REFERENCES Sucursal (idSucursal)
);

CREATE TABLE Alquiler (
	fkReservaA INT UNSIGNED NOT NULL,
	fkServicioA INT UNSIGNED NOT NULL,
	fkAccesorioA INT UNSIGNED NOT NULL,
    costoTotal FLOAT(8, 2) UNSIGNED NOT NULL,
    PRIMARY KEY (fkReservaA, fkServicioA, fkAccesorioA),
    CONSTRAINT fk_resa FOREIGN KEY (fkReservaA)
        REFERENCES Reserva (idReserva),
	CONSTRAINT fk_sera FOREIGN KEY (fkServicioA)
        REFERENCES Servicio (idServicio),
	CONSTRAINT fk_acca FOREIGN KEY (fkAccesorioA)
        REFERENCES Accesorio (idAccesorio)
);