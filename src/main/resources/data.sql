DROP table IF EXISTS almacenes;
DROP table IF EXISTS cajas;

CREATE TABLE almacenes (
id INT AUTO_INCREMENT PRIMARY KEY,
lugar VARCHAR(115),
capacidad INT 
);

INSERT INTO almacenes (lugar, capacidad) VALUES ('Poligono Barna', 150);
INSERT INTO almacenes (lugar, capacidad) VALUES ('Poligono Madriz', 200);
INSERT INTO almacenes (lugar, capacidad) VALUES ('Poligono Valencia', 250);

CREATE TABLE cajas(
num_referencia char(5) PRIMARY KEY,
contenido nvarchar(100),
valor INT,
almacen INT,
id_almacen INT,
FOREIGN KEY (id_almacen) REFERENCES almacenes(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cajas (num_referencia, contenido, valor, id_almacen) VALUES ('A123', 'Perifericos', 890, 1);
INSERT INTO cajas (num_referencia, contenido, valor, id_almacen) VALUES ('B456', 'Ropa', 2500, 2);
INSERT INTO cajas (num_referencia, contenido, valor, id_almacen) VALUES ('C678', 'Herramientas', 25000, 3);
INSERT INTO cajas (num_referencia, contenido, valor, id_almacen) VALUES ('C901', 'Plantas', 580, 3);