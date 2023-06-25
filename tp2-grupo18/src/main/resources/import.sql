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







INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('JUJUY',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('SALTA',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('TUCUMAN',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('FORMOSA',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('CHACO',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('SANTIAGO DEL ESTERO',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('CATAMARCA',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('MISIONES',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('LA RIOJA',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('CORRIENTES',1);
INSERT INTO provincia(provi_nombre,provi_estado) VALUES ('CORDOBA',1);


INSERT INTO autor(autor_nombre,autor_estado) VALUES ('Savatela',1);
INSERT INTO autor(autor_nombre,autor_estado) VALUES ('Martinez',1);
INSERT INTO autor(autor_nombre,autor_estado) VALUES ('Medina',1);


INSERT INTO Sucursal(sucu_nombre,sucu_lugar,provi_id,sucu_estado,sucu_telefono,sucu_dia,sucu_horario,sucu_gmail,sucu_fechainicio) VALUES ('Buenos amigos','3915 Av. General Belgrano',1,1,'3884999999','Lunes a viernes','9:00a.m. 21p.m','contactos@mail.com.ar','2020-06-06');
INSERT INTO Sucursal(sucu_nombre,sucu_lugar,provi_id,sucu_estado,sucu_telefono,sucu_dia,sucu_horario,sucu_gmail,sucu_fechainicio) VALUES ('Veterinaria Luján Jujuy','Av. Pueyrredón 839',2,1,'03885033061','Lunes a viernes','9:00a.m. 21p.m','veterinarialujan@mail.com.ar','2021-03-07');
INSERT INTO Sucursal(sucu_nombre,sucu_lugar,provi_id,sucu_estado,sucu_telefono,sucu_dia,sucu_horario,sucu_gmail,sucu_fechainicio) VALUES ('Veterinaria Como Perros y Gatos','Av. 19 de Abril 997',3,1,'03884235122','Lunes a viernes','9:00a.m. 21p.m','vetcomoperroygatos@mail.com.ar','2020-02-06');
INSERT INTO Sucursal(sucu_nombre,sucu_lugar,provi_id,sucu_estado,sucu_telefono,sucu_dia,sucu_horario,sucu_gmail,sucu_fechainicio) VALUES ('Veterinaria Sandi','Av. Eva Perón 1373',4,1,'03884268743','Lunes a viernes','9:00a.m. 21p.m','veterinariasandi@mail.com.ar','2019-04-23');


INSERT INTO consejo(conse_titulo,conse_texto,autor_id,conse_estado) VALUES ('Esterilización o castración de los gatos','Esterilizar o castrar a los gatos aumenta la posibilidad de que estos animales tengan una vida más larga y saludable, ya que disminuye el riesgo de contraer enfermedades',1,1);
INSERT INTO consejo(conse_titulo,conse_texto,autor_id,conse_estado) VALUES ('¿Qué debo hacer si mi perro vomita?','Puede ser que su perro vomite en cualquier momento lo que no significaría ningún problema.La causa más frecuente de vómitos en los animales es la comida que se le ofrece fuera de su dieta. Por eso, es importante mantener una dieta controlada.',2,1);
