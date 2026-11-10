DROP DATABASE IF EXISTS Triggers1;
CREATE DATABASE Triggers1;
USE Triggers1;

CREATE TABLE productos (
	id_producto INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	precio DECIMAL(10, 2) NOT NULL,
	stock INT NOT NULL,
	fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ventas (
	id_venta INT AUTO_INCREMENT PRIMARY KEY,
	id_producto INT NOT NULL,
	cantidad INT NOT NULL,
	fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE historial_cambios (
	id_cambio INT AUTO_INCREMENT PRIMARY KEY,
	id_producto INT NOT NULL,
	descripcion_cambio VARCHAR(255) NOT NULL,
	fecha_cambio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO productos (nombre, precio, stock) VALUES
('Producto A', 50.00, 10),
('Producto B', 30.00, 3),
('Producto C', 20.00, 0);


DELIMITER //
CREATE TRIGGER after_insert_venta
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN
    UPDATE productos
    SET stock = stock - NEW.cantidad
    WHERE id_producto = NEW.id_producto;
    IF (SELECT stock FROM productos WHERE id_producto = NEW.id_producto) < 5 THEN
        INSERT INTO historial_cambios (id_producto, descripcion_cambio)
        VALUES (NEW.id_producto, 'Nivel bajo de stock');
    END IF;
END;//
DELIMITER ;

INSERT INTO ventas (id_producto, cantidad) VALUES (1, 7);
SELECT * FROM productos;
SELECT * FROM historial_cambios;

-- -------------------------------------------------------------------------------------------

DELIMITER //
CREATE TRIGGER after_update_precio
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN
    IF OLD.precio <> NEW.precio THEN
        INSERT INTO historial_cambios (id_producto, descripcion_cambio)
        VALUES (NEW.id_producto, CONCAT('Cambio de precio: de ', OLD.precio, ' a ', NEW.precio));
    END IF;
END;//
DELIMITER ;

UPDATE productos SET precio = 55.00 WHERE id_producto = 1;
SELECT * FROM historial_cambios;

-- -------------------------------------------------------------------------------------------------

DELIMITER //
CREATE TRIGGER before_delete_producto
BEFORE DELETE ON productos
FOR EACH ROW
BEGIN
    IF OLD.stock > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede eliminar un producto con stock disponible.';
    END IF;
END; //
DELIMITER ;

DELETE FROM productos WHERE id_producto = 1;

DELETE FROM productos WHERE id_producto = 3;
SELECT * FROM productos;


-- ----------------------------------------------------------------------------------------


DELIMITER //
CREATE TRIGGER before_insert_venta
BEFORE INSERT ON ventas
FOR EACH ROW
BEGIN
    IF (SELECT stock FROM productos WHERE id_producto = NEW.id_producto) < NEW.cantidad THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cantidad de venta excede el stock disponible.';
    END IF;
END; //
DELIMITER ;

INSERT INTO ventas (id_producto, cantidad) VALUES (2, 5);

INSERT INTO ventas (id_producto, cantidad) VALUES (2, 2);
SELECT * FROM productos;

-- ------------------------------------------------------------------------------------------

SELECT * FROM historial_cambios;




