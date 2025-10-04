package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    // Additional query methods can be defined here if needed

}
