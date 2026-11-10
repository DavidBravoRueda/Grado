CREATE DATABASE Libreria;
USE Libreria;

CREATE TABLE Autores (
    id_autor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE
);

CREATE TABLE Libros (
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    id_autor INT,
    genero VARCHAR(50) NOT NULL,
    precio DECIMAL(8, 2) NOT NULL,
    publicado YEAR,
    FOREIGN KEY (id_autor) REFERENCES Autores(id_autor)
);

INSERT INTO Autores (nombre, nacionalidad, fecha_nacimiento) VALUES
('Gabriel García Márquez', 'Colombiana', '1927-03-06'),
('Isabel Allende', 'Chilena', '1942-08-02'),
('J.K. Rowling', 'Británica', '1965-07-31'),
('George Orwell', 'Británica', '1903-06-25'),
('Haruki Murakami', 'Japonesa', '1949-01-12');

INSERT INTO Libros (titulo, id_autor, genero, precio, publicado) VALUES
('Cien Años de Soledad', 1, 'Realismo Mágico', 20.99, 1967),
('El amor en los tiempos del cólera', 1, 'Romance', 18.50, 1985),
('La casa de los espíritus', 2, 'Realismo Mágico', 15.75, 1982),
('Paula', 2, 'Autobiografía', 17.00, 1994),
('Harry Potter y la piedra filosofal', 3, 'Fantasía', 25.99, 1997),
('1984', 4, 'Distopía', 19.99, 1949),
('Rebelión en la granja', 4, 'Fábula', 14.50, 1945),
('Kafka en la orilla', 5, 'Ficción', 22.50, 2002),
('Norwegian Wood', 5, 'Romance', 18.75, 1987),
('1Q84', 5, 'Fantasía', 23.40, 2009);

-- x1. Listar todos los libros con su autor y precio
SELECT Libros.titulo AS Libro, Autores.nombre AS Autor, Libros.precio AS Precio
FROM Libros
JOIN Autores ON Libros.id_autor = Autores.id_autor;

-- 2. Mostrar los autores que tienen más de un libro registrado
SELECT Autores.nombre AS Autor, COUNT(Libros.id_libro) AS Total_Libros
FROM Autores
JOIN Libros ON Autores.id_autor = Libros.id_autor
GROUP BY Autores.id_autor
HAVING COUNT(Libros.id_libro) > 1;

-- 3. Obtener el libro más caro
SELECT titulo AS Libro, precio AS Precio
FROM Libros
ORDER BY precio DESC
LIMIT 1;

-- 4. Calcular el precio promedio de todos los libros de un género específico
SELECT genero AS Género, AVG(precio) AS Precio_Promedio
FROM Libros
WHERE genero = 'Realismo Mágico';

-- 5. Listar los libros publicados antes del año 2000
SELECT titulo AS Libro, publicado AS Año_Publicación
FROM Libros
WHERE publicado < 2000;
