-- V3__create_user_table.sql ya existe
-- V4__create_seat_table.sql ya existe

-- V5__create_room_table.sql
CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);
