-- Crear la base de datos del hotel
CREATE DATABASE hotel;
USE hotel;

-- Tabla de Huésped
CREATE TABLE Huesped (
    idHuesped INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    dni VARCHAR(20) UNIQUE,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- Tabla de Tipos de Habitación
CREATE TABLE TipoHabitacion (
    idTipoHabitacion INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20) UNIQUE,
    capacidad INT,
    cantidadCamas INT,
    tipoCamas VARCHAR(50),
    precioNoche DOUBLE
);

-- Tabla de Habitacion
CREATE TABLE Habitacion (
    idHabitacion INT PRIMARY KEY AUTO_INCREMENT,
    numero INT UNIQUE,
    piso INT,
    estado ENUM('Libre', 'Ocupada') DEFAULT 'Libre',
    tipoHabitacion INT,
    FOREIGN KEY (tipoHabitacion) REFERENCES TipoHabitacion(idTipoHabitacion)
);

-- Tabla de Reserva
CREATE TABLE Reserva (
    idReserva INT PRIMARY KEY AUTO_INCREMENT,
    fechaEntrada DATE,
    fechaSalida DATE,
    cantidadDias INT, -- Nueva columna para la cantidad de días de la reserva
    cantidadPersonas INT,
    montoEstadia DOUBLE,
    estado ENUM('Activa', 'Inactiva') DEFAULT 'Activa',
    idHuesped INT,
    FOREIGN KEY (idHuesped) REFERENCES Huesped(idHuesped)
);

-- Tabla de DetalleReserva
CREATE TABLE DetalleReserva (
    idDetalleReserva INT PRIMARY KEY AUTO_INCREMENT,
    idReserva INT,
    idHabitacion INT,
    FOREIGN KEY (idReserva) REFERENCES Reserva(idReserva),
    FOREIGN KEY (idHabitacion) REFERENCES Habitacion(idHabitacion)
);

-- Insertar Tipos de Habitación
INSERT INTO TipoHabitacion (codigo, capacidad, cantidadCamas, tipoCamas, precioNoche)
VALUES
    ('EstSimple', 1, 1, 'Cama Simple', 100.00),
    ('EstDoble', 2, 1, 'Cama Queen', 150.00),
    ('EstTriple', 3, 2, '2 Camas Queen', 200.00),
    ('SuiteLujo', 2, 1, 'Cama King Size', 250.00),
    ('Familiar', 4, 2, '2 Camas King Size', 300.00),
    ('Económica', 1, 1, 'Cama Simple', 80.00),
    ('DobleQueen', 2, 1, '2 Camas Queen', 180.00),
    ('Deluxe', 2, 1, 'Cama King Size', 220.00),
    ('FamiliarSuite', 4, 2, 'Cama King Size y 2 Camas Simples', 320.00),
    ('EstándarTwin', 2, 2, '2 Camas Simples', 140.00);