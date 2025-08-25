-- Migration to add status column to reserved_seat table
ALTER TABLE reserved_seat
    ADD COLUMN status VARCHAR(255) NOT NULL;
