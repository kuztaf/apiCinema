-- V10__create_reserved_seat_table.sql
CREATE TABLE reserved_seat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_id INT NOT NULL,
    seat_id INT NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES reservation(id),
    FOREIGN KEY (seat_id) REFERENCES seat(id)
);
