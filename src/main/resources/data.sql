
insert into PRODUCTO (NOMBRE,DESCRIPCION,PRECIO,DESCUENTO) values ('Pimiento','Rojo de temporada',2.0,1);
insert into PRODUCTO (NOMBRE,DESCRIPCION,PRECIO, DESCUENTO) values ('Tomate', 'Fresco',5.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Manzana', 'Golden',3.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Pera', 'Golden',4.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Manzana', 'Royal Gala',2.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Jamon', 'Ibérico Extremeño de bellota',10.0,2);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Jamón', 'Cocido',4.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Lomo', 'Ibérico de Caña',12.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Pimiento', 'Verde',2.5,1);

insert into ROL (ID_ROL, NOMBRE_ROL ) values (1, 'ROL_USUARIO');
insert into ROL (ID_ROL, NOMBRE_ROL ) values (2,'ROL_ADMIN');

INSERT INTO USUARIO (ID_USUARIO,NOMBRE,APELLIDOS,USERNAME,CONTRASEÑA,EMAIL,FECHA_NAC,NUMERO_TARJETA,CODIGO_SEGURIDAD,DIRECCION_FACTURACION) VALUES (1,'Alejandro','Valero','aaa','$2a$10$fLh4xMgBEXFKC69YL8jvhuraRNlIfgpwLzvSJn6GXSRaIO5Z50vfC','alexvalero34@gmail.com','111',111,28500,'C/catamaran bloque 17 piso 4 letra A');
INSERT INTO USUARIO (ID_USUARIO,NOMBRE,APELLIDOS,USERNAME,CONTRASEÑA,EMAIL,FECHA_NAC,NUMERO_TARJETA,CODIGO_SEGURIDAD,DIRECCION_FACTURACION) VALUES (2,'admin','admin','admin','$2a$10$GNbGuzIiW/Q/wezmOfyPWeVzS1NdUUMxbnwE7lZInWClOlPDWb6eO','admin@gmail.com','050400',1234,28500,'C/catamaran bloque 17 piso 4 letra A');

insert into USUARIO_ROL (ID_USUARIO ,ID_ROL ) values (1, 1);
insert into USUARIO_ROL (ID_USUARIO ,ID_ROL ) values (2, 2);