DROP DATABASE IF EXISTS consultas;
CREATE DATABASE consultas;
USE consultas;

-- Crear la tabla de libros
CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    paginas INT,
    disponible BOOLEAN NOT NULL DEFAULT TRUE
);

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    es_admin BOOLEAN NOT NULL
);

-- Crear la tabla de préstamos
CREATE TABLE IF NOT EXISTS prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_libro VARCHAR(255) NOT NULL,
    nombre_usuario VARCHAR(255) NOT NULL,
    fecha_hora_prestamo DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Insertar algunos libros
INSERT INTO libros (titulo, autor, categoria, paginas, disponible) VALUES
('El señor de los anillos', 'J.R.R. Tolkien', 'Fantasía', 1200, true),
('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', 400, true),
('1984', 'George Orwell', 'Ciencia ficción', 328, true);

-- Insertar algunos usuarios
INSERT INTO usuarios (nombre, apellido, email, contrasena, es_admin) VALUES
('Juan', 'Pérez', 'juan@example.com', 'contraseña123', false),
('María', 'Gómez', 'maria@example.com', 'contraseña456', true),
('Carlos', 'Rodríguez', 'carlos@example.com', 'contraseña789', false);

-- Insertar algunos préstamos (utilizando el nombre del usuario y del libro en lugar de los ID)
INSERT INTO prestamos (nombre_libro, nombre_usuario) VALUES
('El señor de los anillos', 'Juan'),
('Cien años de soledad', 'María'),
('1984', 'Carlos');


-- Consultar todos los libros
SELECT * FROM libros;

-- Consultar todos los usuarios
SELECT * FROM usuarios;

-- Consultar todos los préstamos
SELECT prestamos.id, prestamos.nombre_libro, prestamos.nombre_usuario, prestamos.fecha_hora_prestamo
FROM prestamos;


