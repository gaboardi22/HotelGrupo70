-- Insertar Tipos de Habitación
INSERT INTO TiposHabitacion (nombre, descripcion)
VALUES
    ('Estándar simple', 'Habitación individual con una cama individual.'),
    ('Estándar doble', 'Habitación para dos personas con una cama doble.'),
    ('Estándar triple', 'Habitación para tres personas con tres camas individuales.'),
    ('Suite Lujo', 'Suite de lujo con cama king-size y sala de estar.');

-- Insertar 200 Habitacion
INSERT INTO Habitacion (numero, piso, estado, tipoHabitacion)
SELECT
    n,
    CASE 
        WHEN n <= 50 THEN 1
        WHEN n <= 100 THEN 2
        WHEN n <= 150 THEN 3
        ELSE 4
    END AS piso,
    0 AS estado,
    CASE 
        WHEN n % 4 = 0 THEN 4
        ELSE n % 4
    END AS tipoHabitacion
FROM
    (SELECT (HUNDRED + TENS + ONES) AS n
     FROM
         (SELECT 0 AS HUNDRED UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) H,
         (SELECT 0 AS TENS UNION SELECT 10 UNION SELECT 20 UNION SELECT 30 UNION SELECT 40 UNION SELECT 50 UNION SELECT 60 UNION SELECT 70 UNION SELECT 80 UNION SELECT 90) T,
         (SELECT 0 AS ONES UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) O
     ORDER BY n
     LIMIT 200) Numbers;

-- Insertar huéspedes
INSERT INTO Huesped (nombre, apellido, dni, telefono, email)
VALUES
    ('Juan', 'Perez', '12345678', '123-456-7890', 'juan.perez@example.com'),
    ('Maria', 'Gomez', '23456789', '234-567-8901', 'maria.gomez@example.com'),
    ('Carlos', 'Lopez', '34567890', '345-678-9012', 'carlos.lopez@example.com'),
    ('Laura', 'Rodriguez', '45678901', '456-789-0123', 'laura.rodriguez@example.com'),
    ('Diego', 'Fernandez', '56789012', '567-890-1234', 'diego.fernandez@example.com');