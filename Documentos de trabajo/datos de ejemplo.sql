-- Insertar tipos de habitaciones
INSERT INTO TiposHabitacion (nombre, descripcion)
VALUES
    ('Estándar Simple', 'Habitación individual con cama individual.'),
    ('Estándar Doble', 'Habitación doble con dos camas individuales.'),
    ('Estándar Triple', 'Habitación triple con tres camas individuales.'),
    ('Suite Lujo', 'Suite de lujo con cama king-size y jacuzzi.');

-- Insertar huéspedes de ejemplo
INSERT INTO Huespedes (nombre, apellido, dni, telefono, email)
VALUES
    ('Juan', 'Perez', '12345678', '123-456-7890', 'juan.perez@example.com'),
    ('Maria', 'Gomez', '23456789', '234-567-8901', 'maria.gomez@example.com'),
    ('Carlos', 'Lopez', '34567890', '345-678-9012', 'carlos.lopez@example.com'),
    ('Laura', 'Rodriguez', '45678901', '456-789-0123', 'laura.rodriguez@example.com'),
    ('Diego', 'Fernandez', '56789012', '567-890-1234', 'diego.fernandez@example.com');

-- Inaertar 200 habitaciones
INSERT INTO Habitaciones (numero, piso, estado, tipoHabitacion)
SELECT
    n,
    CASE 
        WHEN n <= 50 THEN 1
        WHEN n <= 100 THEN 2
        WHEN n <= 150 THEN 3
        ELSE 4
    END AS piso,
    'Libre' AS estado,
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


