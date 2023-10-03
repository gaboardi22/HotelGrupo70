-- Crear la base de datos del hotel
CREATE DATABASE hotel;
USE hotel;

-- Tabla de Huésped
CREATE TABLE Huesped (
    idHuesped INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    dni VARCHAR(20),
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- Tabla de Tipos de Habitación
CREATE TABLE TiposHabitacion (
    idTipoHabitacion INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion TEXT
);

-- Tabla de Habitacion
CREATE TABLE Habitacion (
    idHabitacion INT PRIMARY KEY AUTO_INCREMENT,
    numero INT,
    piso INT,
    estado TINYINT,
    tipoHabitacion INT,
    FOREIGN KEY (tipoHabitacion) REFERENCES TiposHabitacion(idTipoHabitacion)
);

-- Tabla de Reserva
CREATE TABLE Reserva (
    idReserva INT PRIMARY KEY AUTO_INCREMENT,
    fechaInicio DATE,
    fechaFin DATE,
    dias INT,
    monto DOUBLE,
    estado TINYINT,
    idHuesped INT,
    idHabitacion INT,
    observacion VARCHAR(250),
    FOREIGN KEY (idHuesped) REFERENCES Huesped(idHuesped),
    FOREIGN KEY (idHabitacion) REFERENCES Habitacion(idHabitacion)
);