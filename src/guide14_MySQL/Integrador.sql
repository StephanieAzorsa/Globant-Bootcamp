USE nba;

/**************************** Candado A: Position 2 ****************************/
/* Teniendo el máximo de asistencias por partido, muestre cuantas veces se logró
   dicho máximo. */
SELECT COUNT(*) AS PosicionDelCandadoA
FROM estadisticas
WHERE Asistencias_por_partido = (SELECT MAX(Asistencias_por_partido)
                                 FROM estadisticas);

/**************************** Candado A: Clave 14043 ****************************/
/* Muestre la suma total del peso de los jugadores, donde la conferencia sea Este
   y la posición sea centro o esté comprendida en otras posiciones. */
SELECT SUM(Peso) AS ClaveDelCandadoA
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
WHERE equipos.Conferencia = 'East'
  AND (jugadores.Posicion = 'C' OR jugadores.Posicion LIKE '%C%');

/**************************** Candado B: Position 3 ****************************/
/*  Muestre la cantidad de jugadores que poseen más asistencias por partidos,
    que el numero de jugadores que tiene el equipo Heat. */
SELECT COUNT(*) AS PosicionDelCandadoB
FROM jugadores
         INNER JOIN estadisticas es
                    ON jugadores.codigo = es.jugador
WHERE es.Asistencias_por_partido > (SELECT COUNT(*)
                                    FROM jugadores
                                    WHERE Nombre_equipo = 'Heat');

/**************************** Candado B: Clave 3480 ****************************/
/*La clave será igual al conteo de partidos jugados durante las temporadas del año 1999.*/
SELECT COUNT(*) AS ClaveDelCandadoB
FROM partidos
WHERE Temporada LIKE '%99%';

/**************************** Candado C: Position 1 ****************************/
SELECT (
                   (COUNT(*)) /
                   (SELECT COUNT(*) FROM jugadores WHERE Peso >= 195) +
                   0.9945
           ) AS PosicionDelCandado
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
WHERE equipos.Conferencia = 'West'
  AND jugadores.Procedencia = 'Michigan';

/**************************** Candado C: Clave 631 ****************************/
/* Para obtener el siguiente código deberás redondear hacia abajo el resultado
   que se devuelve de sumar: el promedio de puntos por partido, el conteo de
   asistencias por partido, y la suma de tapones por partido. Además, este
   resultado debe ser, donde la división sea central.*/

SELECT FLOOR( -- redondear hacia abajo el resultado
                   PromedioPuntosPorPartido + ConteoAsistencias + SumaTapones
           ) AS ClaveDelCandadoC
FROM (SELECT AVG(Puntos_por_partido)        AS PromedioPuntosPorPartido,
             COUNT(Asistencias_por_partido) AS ConteoAsistencias,
             SUM(Tapones_por_partido)       AS SumaTapones
      FROM equipos
               INNER JOIN jugadores j ON equipos.Nombre = j.Nombre_equipo
               INNER JOIN estadisticas es ON j.codigo = es.jugador
      WHERE equipos.Division = 'Central'
     ) AS Subconsulta;

/**************************** Candado D: Position 4 ****************************/
/* Muestre los tapones por partido del jugador Corey Maggette durante la temporada
   00/01. Este resultado debe ser redondeado. Nota: el resultado debe estar
   redondeado. */
SELECT ROUND(Tapones_por_partido) AS PosicionDelCandadoD
FROM jugadores
         INNER JOIN estadisticas es ON jugadores.codigo = es.jugador
WHERE jugadores.Nombre = 'Corey Maggette'
  AND es.Temporada = '00/01';

/**************************** Candado D: Clave 0191 ****************************/
/* Para obtener el siguiente código deberás redondear hacia abajo, la suma de
   puntos por partido de todos los jugadores de procedencia argentina. */
SELECT FLOOR(SUM(Puntos_por_partido)) AS ClaveDelCandadoD
FROM jugadores
         INNER JOIN estadisticas es ON jugadores.codigo = es.jugador
WHERE jugadores.Procedencia = 'Argentina';

/*** Consultas tablas ***/
select *
from jugadores;

select *
from equipos;

select *
from estadisticas;

select *
from partidos