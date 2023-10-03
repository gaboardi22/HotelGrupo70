-- Insertar 100 habitaciones aleatorias distribuidas en 4 pisos
INSERT INTO Habitacion (numero, piso, estado, tipoHabitacion)
SELECT
    n AS numero,
    CASE 
        WHEN n <= 50 THEN 1
        WHEN n <= 100 THEN 2
        WHEN n <= 150 THEN 3
        ELSE 4
    END AS piso,
    'Libre' AS estado,
    CASE 
        WHEN n % 10 = 0 THEN 10
        ELSE n % 10
    END AS tipoHabitacion
FROM (
    SELECT 
        ROW_NUMBER() OVER () AS n
    FROM 
        (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10) AS a,
        (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10) AS b
) AS Numbers
LIMIT 200;

-- Insertar 10 huéspedes aleatorios
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

-- Variables
DECLARE @StartDate DATE;
DECLARE @EndDate DATE;
DECLARE @Guests INT;
DECLARE @RoomType INT;

-- Fecha de inicio y fin para las reservas (intervalo de 1 año)
SET @StartDate = '2024-01-01';
SET @EndDate = '2024-12-31';

-- Generar 50 reservas aleatorias
SET @Guests = 1;
WHILE @Guests <= 6
BEGIN
    SET @RoomType = 1; -- Tipo de habitación (desde EstSimple hasta EstándarTwin)

    WHILE @RoomType <= 10
    BEGIN
        -- Fecha de entrada aleatoria dentro del intervalo
        SET @StartDate = DATEADD(day, ROUND(RAND() * 364, 0), @StartDate);

        -- Fecha de salida aleatoria entre 1 y 7 días después de la fecha de entrada
        SET @EndDate = DATEADD(day, ROUND(RAND() * 6 + 1, 0), @StartDate);

        -- Insertar reserva con datos aleatorios
        INSERT INTO Reserva (fechaEntrada, fechaSalida, cantidadDias, cantidadPersonas, montoEstadia, idHuesped)
        VALUES (
            @StartDate,
            @EndDate,
            DATEDIFF(@EndDate, @StartDate),
            @Guests,
            (SELECT precioNoche FROM TipoHabitacion WHERE idTipoHabitacion = @RoomType) * DATEDIFF(@EndDate, @StartDate),
            ROUND(RAND() * 10) + 1 -- ID de huésped aleatorio del 1 al 10
        );

        -- Obtener el siguiente tipo de habitación
        SET @RoomType = @RoomType + 1;
    END;

    -- Incrementar la cantidad de huéspedes
    SET @Guests = @Guests + 1;
END;

-- Variables
SET @Guests = 1;
SET @RoomType = 1;
SET @StartDate = '2024-01-01'; -- Fecha de inicio
SET @EndDate = '2024-12-31'; -- Fecha de fin

-- Generar 50 reservas aleatorias
DELIMITER //
CREATE PROCEDURE GenerateRandomReservations()
BEGIN
  DECLARE i INT DEFAULT 1;
  
  WHILE i <= 50 DO
    SET @Guests = FLOOR(RAND() * 6) + 1; -- Entre 1 y 6 personas
    SET @RoomType = FLOOR(RAND() * 10) + 1; -- Entre 1 y 10 tipos de habitación
    SET @StartDate = DATE_ADD(@StartDate, INTERVAL FLOOR(RAND() * 365) DAY); -- Fecha de inicio aleatoria
    SET @RandomDays = FLOOR(RAND() * 6) + 1; -- Entre 1 y 7 días de estancia
    SET @EndDate = DATE_ADD(@StartDate, INTERVAL @RandomDays DAY); -- Calcular fecha de finalización
    
    INSERT INTO Reserva (fechaEntrada, fechaSalida, cantidadDias, cantidadPersonas, montoEstadia, estado, idHuesped)
    VALUES (
        @StartDate,
        @EndDate,
        @RandomDays,
        @Guests,
        0.0,
        'Activa',
        FLOOR(RAND() * 10) + 1
    );
    
    -- Calcular monto de la estadía y actualizar la reserva
    SET @ReservaID = LAST_INSERT_ID();
    UPDATE Reserva
    SET montoEstadia = (
        SELECT precioNoche
        FROM TipoHabitacion
        WHERE idTipoHabitacion = @RoomType
    ) * @RandomDays
    WHERE idReserva = @ReservaID;
    
    SET i = i + 1;
  END WHILE;
END //
DELIMITER ;

-- Ejecutar el procedimiento
CALL GenerateRandomReservations();
