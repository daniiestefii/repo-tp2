INSERT INTO categoria(cate_nombre,cate_estado) VALUES ('Vestimenta',1);
INSERT INTO categoria(cate_nombre,cate_estado) VALUES ('Higiene',1);
INSERT INTO categoria(cate_nombre,cate_estado) VALUES ('Accesorio',1);
INSERT INTO categoria(cate_nombre,cate_estado) VALUES ('Alimento',1);
INSERT INTO producto(Prod_name, Prod_codigo, Prod_precio, cate_id, Prod_descuento, Prod_estado ) VALUES ('Collar para perro', 3213, 5000, 1, 20, 1);
INSERT INTO producto(Prod_name, Prod_codigo, Prod_precio, cate_id, Prod_descuento, Prod_estado ) VALUES ('Collar isabelino',4546,2600,1,10,1);
INSERT INTO producto(Prod_name, Prod_codigo, Prod_precio, cate_id, Prod_descuento, Prod_estado ) VALUES ('Cepillo de doble cerda',890,120,2,0,1);
INSERT INTO empleados(Emple_nombre,Emple_apellido,Emple_dni,Emple_estado) VALUES ('Juan','Perez',43345312,1);
INSERT INTO empleados(Emple_nombre,Emple_apellido,Emple_dni,Emple_estado) VALUES ('Lucaz','Diaz',42464754,1);
INSERT INTO empleados(Emple_nombre,Emple_apellido,Emple_dni,Emple_estado) VALUES ('Maria','Gomez',41868488,1);
INSERT INTO empleados(Emple_nombre,Emple_apellido,Emple_dni,Emple_estado) VALUES ('Roberto','Vazquez',40456321,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Lunes','9 a 12 - 16 a 18',1,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Martes','9 a 12 - 16 a 18',2,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Miercoles','9 a 12 - 16 a 18',1,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Jueves','9 a 12 - 16 a 18',3,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Viernes','9 a 12 - 16 a 18',2,1);
INSERT INTO servicios(Serv_dia,Serv_horario,Emple_id,Serv_estado) VALUES ('Sabado','9 a 12 - 16 a 18',4,1);
INSERT INTO noticias(Noti_titulo,Noti_texto,Noti_estado) VALUES ('CONSEJOS VETERINARIOS','Alimentación adecuada: Proporciona a tu mascota una dieta equilibrada y de alta calidad, adecuada para su especie, raza, edad y tamaño. Consulta con tu veterinario para obtener recomendaciones específicas. ',1);
INSERT INTO noticias(Noti_titulo,Noti_texto,Noti_estado) VALUES ('IMPORTANCIA DE EVITAR QUE NUESTRAS MASCOTAS SALGAN SOLAS DE CASA',' Seguridad: Al permitir que una mascota salga sin supervisión, aumentamos su riesgo de sufrir accidentes o lesiones. Pueden ser atropelladas por vehículos, ser atacadas por otros animales o incluso extraviarse y perderse.',1);
