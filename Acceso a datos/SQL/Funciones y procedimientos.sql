DROP DATABASE IF EXISTS Funciones_procedimientos;
CREATE DATABASE Funciones_procedimientos;
USE Funciones_procedimientos;

CREATE TABLE clientes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	telefono VARCHAR(20),
	direccion VARCHAR(255),
	fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Categorías
CREATE TABLE categorias (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL
);

-- Tabla de Productos
CREATE TABLE productos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	descripcion TEXT,
	precio DECIMAL(10,2) NOT NULL,
	stock INT NOT NULL DEFAULT 0,
	categoria_id INT,
	fecha_agregado DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);


-- Tabla de Pedidos
CREATE TABLE pedidos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	cliente_id INT NOT NULL,
	fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
	estado ENUM('Pendiente', 'Pagado', 'Enviado') DEFAULT 'Pendiente',
	FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabla de Detalle del Pedido
CREATE TABLE detalle_pedido (
	id INT AUTO_INCREMENT PRIMARY KEY,
	pedido_id INT NOT NULL,
	producto_id INT NOT NULL,
	cantidad INT NOT NULL,
	FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
	FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- Tabla de Pagos
CREATE TABLE pagos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	pedido_id INT NOT NULL,
	monto_pago DECIMAL(10,2) NOT NULL,
	fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);


INSERT INTO categorias (nombre) VALUES ('Electrónica');
INSERT INTO categorias (nombre) VALUES ('Ropa');
INSERT INTO categorias (nombre) VALUES ('Hogar');

-- Insertar productos
INSERT INTO productos (nombre, descripcion, precio, stock, categoria_id)
VALUES
('Smartphone', 'Teléfono móvil de última generación', 599.99, 50, 1),
('Laptop', 'Laptop portátil 15 pulgadas', 799.99, 30, 1),
('Camiseta', 'Camiseta de algodón para hombre', 19.99, 100, 2),
('Silla de oficina', 'Silla ergonómica para oficina', 129.99, 20, 3);

-- Insertar clientes
INSERT INTO clientes (nombre, email, telefono, direccion)
VALUES
('Juan Pérez', 'juan.perez@email.com', '555-1234', 'Calle Falsa 123'),
('Ana Gómez', 'ana.gomez@email.com', '555-5678', 'Avenida Siempre Viva 456');

-- Insertar un pedido
INSERT INTO pedidos (cliente_id, estado)
VALUES
(1, 'Pendiente'),
(2, 'Pendiente');

-- Insertar detalles de los pedidos
INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad)
VALUES
(1, 1, 2),  -- Juan Pérez compra 2 Smartphones
(1, 3, 1),  -- Juan Pérez compra 1 Camiseta
(2, 2, 1),  -- Ana Gómez compra 1 Laptop
(2, 4, 2);  -- Ana Gómez compra 2 Sillas de oficina

-- Insertar pagos
INSERT INTO pagos (pedido_id, monto_pago)
VALUES
(1, 619.97),  -- Pago de Juan Pérez por 2 Smartphones y 1 Camiseta
(2, 1059.97); -- Pago de Ana Gómez por 1 Laptop y 2 Sillas de oficina



DELIMITER $$
DROP FUNCTION IF EXISTS calcular_descuento$$
CREATE FUNCTION calcular_descuento(producto_id INT, descuento_porcentaje DECIMAL(5,2))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE precio_producto DECIMAL(10,2);
    SELECT precio INTO precio_producto FROM productos WHERE id = producto_id;
    RETURN precio_producto * (1 - descuento_porcentaje / 100);
END$$
DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS calcular_total_pedido$$
CREATE FUNCTION calcular_total_pedido(pedido_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10,2) DEFAULT 0.00;
    SELECT SUM(dp.cantidad * p.precio) INTO total
    FROM detalle_pedido dp
    JOIN productos p ON dp.producto_id = p.id
    WHERE dp.pedido_id = pedido_id;
    RETURN IFNULL(total, 0.00);
END$$
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS registrar_pedido$$
CREATE PROCEDURE registrar_pedido(IN cliente_id INT, IN productos_json JSON)
BEGIN
    DECLARE pedido_id INT;
    DECLARE producto_id INT;
    DECLARE cantidad INT;
    DECLARE idx INT DEFAULT 0;
    DECLARE total_productos INT;
    INSERT INTO pedidos (cliente_id) VALUES (cliente_id);
    SET pedido_id = LAST_INSERT_ID();
    SET total_productos = JSON_LENGTH(productos_json);
    WHILE idx < total_productos DO
        SET producto_id = JSON_UNQUOTE(JSON_EXTRACT(productos_json, CONCAT('$[', idx, '].producto_id')));
        SET cantidad = JSON_UNQUOTE(JSON_EXTRACT(productos_json, CONCAT('$[', idx, '].cantidad')));
        INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad)
        VALUES (pedido_id, producto_id, cantidad);
        UPDATE productos SET stock = stock - cantidad WHERE id = producto_id;
        SET idx = idx + 1;
    END WHILE;
END$$
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS realizar_pago$$
CREATE PROCEDURE realizar_pago(IN pedido_id INT, IN monto_pago DECIMAL(10,2))
BEGIN
    DECLARE total_pedido DECIMAL(10,2);
    DECLARE mensaje_error TEXT;
    SELECT calcular_total_pedido(pedido_id) INTO total_pedido;
    IF monto_pago >= total_pedido THEN
        INSERT INTO pagos (pedido_id, monto_pago) VALUES (pedido_id, monto_pago);
        UPDATE pedidos SET estado = 'Pagado' WHERE id = pedido_id;
    ELSE
        SET mensaje_error = CONCAT('El monto proporcionado (', monto_pago, ') es insuficiente. Total requerido: ', total_pedido);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = mensaje_error;
    END IF;
END$$
DELIMITER ;



SELECT calcular_descuento(1, 10);
SELECT calcular_total_pedido(1);
CALL registrar_pedido(1, '[{"producto_id": 1, "cantidad": 2}, {"producto_id": 3, "cantidad": 1}]');
CALL realizar_pago(1, 1219.97);








    