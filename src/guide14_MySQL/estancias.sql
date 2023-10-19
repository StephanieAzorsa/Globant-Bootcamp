# b 2) Buscar y listar las casas disponibles para el periodo
# comprendido entre el 1 de agosto de 2020 y el 31 de
# agosto de 2020 en Reino Unido. ✔
SELECT *
FROM casas
WHERE pais = 'Reino Unido'
  AND fecha_desde = '2020-08-01'
  AND fecha_hasta = '2020-08-31';

# c 3)Encuentra todas aquellas familias cuya dirección de
# mail sea de Hotmail. ✔
SELECT *
FROM familias
WHERE email LIKE '%hotmail.com';

# d 4)Consulta la BD para que te devuelva aquellas casas
# disponibles a partir de una fecha dada y un número de
# días específico.
SELECT *
FROM casas;


# e 5)Listar los datos de todos los clientes que en algún
# momento realizaron una estancia y la descripción de
# la casa donde la realizaron. ✔
SELECT clientes.nombre,
       estancias.id_estancia,
       casas.ciudad,
       casas.tipo_vivienda,
       comentarios.comentario
FROM clientes
         INNER JOIN estancias
                    ON clientes.id_cliente = estancias.id_cliente
         INNER JOIN casas
                    ON estancias.id_casa = casas.id_casa
         INNER JOIN comentarios
                    ON comentarios.id_comentario = casas.id_casa;

select *
from estancias;
select *
from clientes;
select *
from casas;
select *
from comentarios;

# f 6)Listar todas las estancias que han sido reservadas por
# un cliente, mostrar el nombre, país y ciudad del cliente
# y además la información de la casa que reservó.
# La que reemplazaría a la anterior ✔
SELECT clientes.nombre,
       clientes.pais,
       clientes.ciudad,
       casas.tipo_vivienda
FROM clientes
         INNER JOIN estancias
                    ON clientes.id_cliente = estancias.id_cliente
         INNER JOIN casas
                    ON estancias.id_casa = casas.id_casa
WHERE id_estancia = 1;


# g 7)Debido a la devaluación de la libra esterlina con
# respecto al euro se desea incrementar el precio por día
# en un 5% de todas las casas del Reino Unido. Mostar
# los precios actualizados. ✔
select *
from casas;
ALTER TABLE casas
    DROP COLUMN precio_actualizado;

ALTER TABLE casas
    ADD COLUMN precio_actualizado NUMERIC(15, 2);

UPDATE casas
SET precio_actualizado = precio_habitacion * 1.1
WHERE pais = 'Reino Unido';


# h 8)Obtener el número de casas que existen para cada uno
# de los países diferentes. ✔
SELECT pais, COUNT(*) AS cantidad
FROM casas
GROUP BY pais;

# i 9)Busca y listar aquellas casas del Reino Unido de
# las que se ha dicho de ellas (comentarios) que
# están ‘limpias’. ✔
SELECT casas.pais, comentarios.comentario
FROM comentarios
         INNER JOIN casas
                    ON casas.id_casa = comentarios.id_comentario
WHERE comentarios.comentario LIKE '%limpia%'
  AND casas.pais = 'Reino Unido';

# j 10) Insertar nuevos datos en la tabla estancias verificando
# la disponibilidad de las fechas.
INSERT INTO estancias (id_cliente, id_casa,
                       nombre_huesped, fecha_desde,
                       fecha_hasta)
VALUES (8, 7, 'Juan', '2020-08-01', '2020-08-05');
