package com.cinemaapp.backend.service;


import com.cinemaapp.backend.entitys.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    void addMovie(Movie movieEntity);

    List<Movie> getAll();

    List<Movie> getMovieTopThree(Integer cinemaId);

    List<Movie> getMovieForWeek(Integer cinemaId);

    List<Movie> getMovieByDate();

    void deleteMovie(Integer movieId);

    Optional<Movie> getById(Integer movieId);
}
