-- V6__create_movie_table.sql
CREATE TABLE movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL UNIQUE,
    duration INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    description VARCHAR(500),
    poster_url VARCHAR(255)
);
