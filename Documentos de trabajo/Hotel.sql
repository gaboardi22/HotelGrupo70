-- Crear la base de datos del hotel
CREATE DATABASE HotelDB;
USE HotelDB;

-- Tabla de Huéspedes
CREATE TABLE Huespedes (
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

-- Tabla de Habitaciones
CREATE TABLE Habitaciones (
    idHabitacion INT PRIMARY KEY AUTO_INCREMENT,
    numero INT,
    piso INT,
    estado ENUM('Ocupada', 'Libre'),
    tipoHabitacion INT,
    FOREIGN KEY (tipoHabitacion) REFERENCES TiposHabitacion(idTipoHabitacion)
);

-- Tabla de Reservas
CREATE TABLE Reservas (
    idReserva INT PRIMARY KEY AUTO_INCREMENT,
    fechaInicio DATE,
    fechaFin DATE,
    dias INT,
    monto DECIMAL(10, 2),
    estado ENUM('Pendiente', 'Confirmada', 'Cancelada'),
    idHuesped INT,
    idHabitacion INT,
    FOREIGN KEY (idHuesped) REFERENCES Huespedes(idHuesped),
    FOREIGN KEY (idHabitacion) REFERENCES Habitaciones(idHabitacion)
);