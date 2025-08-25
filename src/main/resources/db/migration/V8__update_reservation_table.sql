-- 1. Eliminar la foreign key existente hacia movie
ALTER TABLE reservation 
DROP FOREIGN KEY fk_reservation_movie;

-- 2. Eliminar la columna movie_id
ALTER TABLE reservation 
DROP COLUMN movie_id;

-- 3. Agregar columna showtime_id
ALTER TABLE reservation 
ADD COLUMN showtime_id INT NOT NULL;

-- 4. Crear nueva foreign key hacia showtime
ALTER TABLE reservation 
ADD CONSTRAINT fk_reservation_showtime
FOREIGN KEY (showtime_id) REFERENCES showtime(id);