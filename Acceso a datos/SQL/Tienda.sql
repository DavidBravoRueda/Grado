DROP DATABASE IF EXISTS Tienda;
CREATE DATABASE IF NOT EXISTS Tienda;
USE Tienda;

CREATE TABLE Productos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100),
	categoria VARCHAR(50),
	precio DECIMAL(10, 2)
);

INSERT INTO Productos (nombre, categoria, precio) VALUES
('Camiseta', 'Ropa', 19.99),
('Pantalón', 'Ropa', 39.99),
('Zapatos', 'Calzado', 49.99),
('Sandalias', 'Calzado', 24.99),
('Gorra', 'Accesorios', 9.99);

CREATE TABLE Ventas (
	id INT AUTO_INCREMENT PRIMARY KEY,
	producto_id INT,
	cantidad INT,
	fecha DATE,
	FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

INSERT INTO Ventas (producto_id, cantidad, fecha) VALUES
(1, 3, '2025-01-01'),
(2, 2, '2025-01-02'),
(3, 1, '2025-01-03'),
(4, 5, '2025-01-04');


CREATE VIEW ResumenVentas AS
SELECT 
    p.nombre AS Producto,
    p.categoria AS Categoria,
    SUM(v.cantidad) AS Cantidad_Total_Vendida,
    SUM(v.cantidad * p.precio) AS Ingreso_Total
FROM 
    Productos p
JOIN 
    Ventas v ON p.id = v.producto_id
GROUP BY 
    p.id, p.nombre, p.categoria;

SELECT * FROM ResumenVentas;



DROP VIEW IF EXISTS ResumenVentas;
CREATE VIEW ResumenVentas AS
SELECT 
    p.nombre AS Producto,
    p.categoria AS Categoria,
    SUM(v.cantidad) AS Cantidad_Total_Vendida,
    SUM(v.cantidad * p.precio) AS Ingreso_Total
FROM 
    Productos p
JOIN 
    Ventas v ON p.id = v.producto_id
WHERE 
    p.categoria = 'Ropa'
GROUP BY 
    p.id, p.nombre, p.categoria;

SELECT * FROM ResumenVentas;
