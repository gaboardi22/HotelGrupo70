-- Generar 10 habitaciones por piso en un edificio de 4 pisos
DELIMITER //
CREATE PROCEDURE GenerarHabitaciones()
BEGIN
    DECLARE piso INT;
    DECLARE habitacion INT;
    DECLARE tipoHabitacion INT;
    
    SET piso = 1;
    
    WHILE piso <= 4 DO
        SET habitacion = 1;
        
        WHILE habitacion <= 10 DO
            -- Asignar un tipo de habitación de manera aleatoria (del 1 al 10)
            SET tipoHabitacion = FLOOR(1 + (RAND() * 10));
            
            INSERT INTO Habitacion (numero, piso, tipoHabitacion)
            VALUES (CONCAT(piso, LPAD(habitacion, 2, '0')), piso, tipoHabitacion);
            
            SET habitacion = habitacion + 1;
        END WHILE;
        
        SET piso = piso + 1;
    END WHILE;
END //
DELIMITER ;

-- Llamar al procedimiento para generar las habitaciones
CALL GenerarHabitaciones();

-- Generar 10 huéspedes aleatorios
INSERT INTO Huesped (nombre, apellido, dni, telefono, email)
VALUES
    ('Juan', 'Perez', '12345678', '123-456-7890', 'juan.perez@example.com'),
    ('Maria', 'Gomez', '23456789', '234-567-8901', 'maria.gomez@example.com'),
    ('Carlos', 'Lopez', '34567890', '345-678-9012', 'carlos.lopez@example.com'),
    ('Laura', 'Rodriguez', '45678901', '456-789-0123', 'laura.rodriguez@example.com'),
    ('Diego', 'Fernandez', '56789012', '567-890-1234', 'diego.fernandez@example.com'),
    ('Ana', 'Gonzalez', '67890123', '678-901-2345', 'ana.gonzalez@example.com'),
    ('Pedro', 'Torres', '78901234', '789-012-3456', 'pedro.torres@example.com'),
    ('Sofia', 'Diaz', '89012345', '890-123-4567', 'sofia.diaz@example.com'),
    ('Lucas', 'Martinez', '90123456', '901-234-5678', 'lucas.martinez@example.com'),
    ('Camila', 'Sanchez', '12340123', '123-401-2345', 'camila.sanchez@example.com');

-- Generar 3 reservas por cliente
DELIMITER //
CREATE PROCEDURE GenerarReservas()
BEGIN
    DECLARE cliente INT;
    DECLARE personas INT;
    DECLARE habitacionesNecesarias INT;
    
    SET cliente = 1;
    
    WHILE cliente <= 10 DO
        SET personas = FLOOR(2 + (RAND() * 5)); -- Entre 2 y 6 personas por reserva
        SET habitacionesNecesarias = CEIL(personas / 4); -- Calcular el número de habitaciones necesarias
        
        INSERT INTO Reserva (fechaEntrada, fechaSalida, cantidadDias, cantidadPersonas, montoEstadia, idHuesped)
        SELECT
            DATE_ADD(CURDATE(), INTERVAL cliente DAY), -- Fecha de entrada (variada por cliente)
            DATE_ADD(CURDATE(), INTERVAL cliente + 3 DAY), -- Fecha de salida (variada por cliente)
            4, -- 4 días de estadía
            personas, -- Cantidad de personas
            0, -- Monto de estadía (se calculará más adelante)
            cliente; -- ID del huésped
            
        SET @ultimaReserva = LAST_INSERT_ID(); -- Obtener el ID de la última reserva
        
        -- Asignar habitaciones a la reserva
        WHILE habitacionesNecesarias > 0 DO
            INSERT INTO DetalleReserva (idReserva, idHabitacion)
            SELECT @ultimaReserva, h.idHabitacion
            FROM Habitacion h
            LEFT JOIN DetalleReserva dr ON h.idHabitacion = dr.idHabitacion
            WHERE dr.idReserva IS NULL
            LIMIT 1;
            
            SET habitacionesNecesarias = habitacionesNecesarias - 1;
        END WHILE;
        
        -- Calcular el monto de estadía y actualizar la reserva
        UPDATE Reserva
        SET montoEstadia = (
            SELECT SUM(th.precioNoche)
            FROM Reserva r
            INNER JOIN DetalleReserva dr ON r.idReserva = dr.idReserva
            INNER JOIN Habitacion h ON dr.idHabitacion = h.idHabitacion
            INNER JOIN TipoHabitacion th ON h.tipoHabitacion = th.idTipoHabitacion
            WHERE r.idReserva = @ultimaReserva
        )
        WHERE idReserva = @ultimaReserva;
        
        SET cliente = cliente + 1;
    END WHILE;
END //
DELIMITER ;

-- Llamar al procedimiento para generar las reservas
CALL GenerarReservas();
