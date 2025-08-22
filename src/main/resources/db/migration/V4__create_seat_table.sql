-- V8__create_seat_table.sql
CREATE TABLE seat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `row` INT NOT NULL,
    `column` INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id)
);
