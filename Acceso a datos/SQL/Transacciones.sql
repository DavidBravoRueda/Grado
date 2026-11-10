DROP DATABASE IF EXISTS Transacciones;
CREATE DATABASE Transacciones;
USE Transacciones;

CREATE TABLE productos (
	id_producto INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255) NOT NULL,
	categoria VARCHAR(100),
	precio DECIMAL(8, 2) NOT NULL,
	stock INT NOT NULL
);

CREATE TABLE clientes (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255) NOT NULL,
	correo VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE pedidos (
	id_pedido INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
	fecha_pedido DATETIME NOT NULL,
	total DECIMAL(10, 2) NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE detalle_pedidos (
	id_detalle INT AUTO_INCREMENT PRIMARY KEY,
	id_pedido INT NOT NULL,
	id_producto INT NOT NULL,
	cantidad INT NOT NULL,
	subtotal DECIMAL(10, 2) NOT NULL,
	FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
	FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);


INSERT INTO productos (nombre, categoria, precio, stock) VALUES
('Teclado mecánico', 'Periféricos', 45.99, 50),
('Ratón inalámbrico', 'Periféricos', 25.49, 30),
('Monitor LED 24"', 'Monitores', 189.99, 20),
('Disco SSD 1TB', 'Almacenamiento', 99.99, 15),
('Auriculares gaming', 'Audio', 59.99, 25),
('Cargador USB-C', 'Accesorios', 15.99, 100),
('Altavoces Bluetooth', 'Audio', 39.99, 40),
('Tarjeta gráfica RTX 3060', 'Componentes', 299.99, 10),
('Memoria RAM 16GB DDR4', 'Componentes', 79.99, 35),
('Micrófono USB', 'Audio', 49.99, 20);


INSERT INTO clientes (nombre, correo) VALUES
('Juan Pérez', 'juan.perez@example.com'),
('María López', 'maria.lopez@example.com'),
('Carlos García', 'carlos.garcia@example.com'),
('Ana Torres', 'ana.torres@example.com'),
('Luis Fernández', 'luis.fernandez@example.com');



DELIMITER $$
CREATE PROCEDURE registrar_pedido(
IN p_id_cliente INT,
IN p_id_producto INT,
IN p_cantidad INT,
IN p_total DECIMAL(10,2)
)
BEGIN
	DECLARE v_stock INT;
    SELECT stock into v_stock FROM productos
    WHERE id_producto = p_id_producto;
    
    IF v_stock >= p_cantidad THEN
		START TRANSACTION;
        
        UPDATE productos SET stock = stock - p_cantidad
        WHERE id_producto = p_id_producto;
        
        INSERT INTO pedidos (id_cliente, fecha_pedido, total)
        VALUES (p_id_cliente, NOW(), p_total);
        
        SET @id_pedido = LAST_INSERT_ID();
        
        INSERT INTO detalle_pedidos (id_pedido, id_producto, cantidad, subtotal)
        VALUES (@id_pedido, p_id_producto, p_cantidad, p_cantidad * (
			SELECT precio FROM productos WHERE id_producto = p_id_producto
		));
        
        COMMIT;
	ELSE 
		ROLLBACK;
	END IF;
END $$
DELIMITER //


CALL registrar_pedido(1, 1, 2, 91.98);
CALL registrar_pedido(2, 1, 100, 4599.00);

CREATE INDEX idx_nombre_producto ON productos(nombre);
CREATE INDEX idx_fecha_pedido ON pedidos(fecha_pedido);
CREATE INDEX idx_id_cliente ON pedidos(id_cliente);
CREATE INDEX idx_id_pedido_producto ON detalle_pedidos(id_pedido, id_producto);
    