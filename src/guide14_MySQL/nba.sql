USE nba;

# 1.Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT nombre
FROM jugadores
ORDER BY nombre;

# 2.Mostrar el nombre de los jugadores que sean pivots (‘C’) y que
# pesen más de 200 libras,ordenados por nombre alfabéticamente.
SELECT nombre
FROM jugadores
WHERE posicion = 'C'
  AND peso > 200
ORDER BY nombre;

# 3.Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT nombre
FROM equipos
ORDER BY nombre;

# 4.Mostrar el nombre de los equipos del este (East).
SELECT nombre
FROM equipos
WHERE conferencia = 'East';

# 5.Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT nombre, Ciudad
FROM equipos
WHERE Ciudad LIKE 'c%'
   OR Ciudad LIKE 'C%';

# 6.Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT jugadores.nombre, equipos.Nombre
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
ORDER BY equipos.Nombre;

# 7.Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
SELECT jugadores.nombre, equipos.Nombre
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
WHERE equipos.Nombre = 'Raptors'
ORDER BY jugadores.nombre;

# 8.Mostrar los puntos por partido del jugador ‘Pau Gasol’.
SELECT puntos_por_partido, nombre
FROM estadisticas
         INNER JOIN jugadores ON estadisticas.jugador = jugadores.codigo
WHERE nombre = 'Pau Gasol';

# 9.Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT puntos_por_partido, nombre, temporada
FROM estadisticas
         INNER JOIN jugadores ON estadisticas.jugador = jugadores.codigo
WHERE nombre = 'Pau Gasol'
  AND temporada = '04/05';

# 10.Mostrar el número de puntos de cada jugador en toda su carrera.
SELECT nombre, SUM(puntos_por_partido)
FROM estadisticas
         INNER JOIN jugadores ON estadisticas.jugador = jugadores.codigo
GROUP BY nombre;

# 11.Mostrar el número de jugadores de cada equipo.
SELECT equipos.Nombre, COUNT(jugadores.Nombre)
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
GROUP BY equipos.Nombre;

# 12.Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT nombre, SUM(puntos_por_partido)
FROM estadisticas
         INNER JOIN jugadores ON estadisticas.jugador = jugadores.codigo
GROUP BY nombre
ORDER BY SUM(puntos_por_partido) DESC
LIMIT 1;

# 13.Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT equipos.Nombre, equipos.conferencia, equipos.division
FROM jugadores
         INNER JOIN equipos ON equipos.Nombre = jugadores.Nombre_equipo
WHERE altura = (SELECT MAX(altura)
                FROM jugadores);

# 14.Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.

# 15.Mostrar quien gana en cada partido (código, equipo_local, equipo_visitante,equipo_ganador),
# en caso de empate sera null
SELECT partidos.codigo,
       partidos.equipo_local,
       partidos.equipo_visitante,
       CASE
           WHEN partidos.puntos_local > partidos.puntos_visitante THEN partidos.equipo_local
           WHEN partidos.puntos_local < partidos.puntos_visitante THEN partidos.equipo_visitante
           END AS equipo_ganador
FROM partidos;