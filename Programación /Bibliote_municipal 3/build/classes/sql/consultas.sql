DROP DATABASE IF EXISTS consultas;
CREATE DATABASE consultas;
USE consultas;
-- Crear la tabla de libros
CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    num_paginas INT,
    disponible BOOLEAN NOT NULL
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

-- Insertar algunos libros
INSERT INTO libros (titulo, autor, categoria, num_paginas, disponible) VALUES
('El señor de los anillos', 'J.R.R. Tolkien', 'Fantasía', 1200, true),
('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', 400, true),
('1984', 'George Orwell', 'Ciencia ficción', 328, true);

-- Insertar algunos usuarios
INSERT INTO usuarios (nombre, apellido, email, contrasena, es_admin) VALUES
('Juan', 'Pérez', 'juan@example.com', 'contraseña123', false),
('María', 'Gómez', 'maria@example.com', 'contraseña456', true),
('Carlos', 'Rodríguez', 'carlos@example.com', 'contraseña789', false);

-- Consultar todos los libros
SELECT * FROM libros;

-- Consultar todos los usuarios
SELECT * FROM usuarios;
