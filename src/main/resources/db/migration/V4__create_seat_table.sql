-- V8__create_seat_table.sql
CREATE TABLE seat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `seat_row` INT NOT NULL,
    `seat_column` INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id)
);
