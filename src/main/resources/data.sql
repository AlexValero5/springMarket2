
insert into PRODUCTO (NOMBRE,DESCRIPCION,PRECIO,DESCUENTO) values ('Pimiento','Rojo de temporada',2.0,1);
insert into PRODUCTO (NOMBRE,DESCRIPCION,PRECIO, DESCUENTO) values ('Tomate', 'Fresco',5.0,1);
insert into PRODUCTO (NOMBRE, DESCRIPCION,PRECIO, DESCUENTO) values ('Manzana', 'Golden',3.0,1);

insert into ROL (ID_ROL, NOMBRE_ROL ) values (1, 'ROL_USUARIO');
insert into ROL (ID_ROL, NOMBRE_ROL ) values (2,'ROL_ADMIN');

INSERT INTO USUARIO (ID_USUARIO,NOMBRE,APELLIDOS,USERNAME,CONTRASEÑA,EMAIL,FECHA_NAC,NUMERO_TARJETA,CODIGO_SEGURIDAD,DIRECCION_FACTURACION) VALUES (1,'Alejandro','Valero','aaa','$2a$10$fLh4xMgBEXFKC69YL8jvhuraRNlIfgpwLzvSJn6GXSRaIO5Z50vfC','alexvalero34@gmail.com','111',111,28500,'C/catamaran bloque 17 piso 4 letra A');


insert into USUARIO_ROL (ID_USUARIO ,ID_ROL ) values (1, 1);