package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.MovieDao;
import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.service.MovieService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void addMovie(Movie movieEntity) {
        movieDao.save(movieEntity);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.findAll();
    }

    @Override
    public List<Movie> getMovieTopThree(Integer cinemaId) {
        LocalDate date = new LocalDate();
        return movieDao.findTopThree(cinemaId, date.toDate(), PageRequest.of(0,3));
    }

    @Override
    public List<Movie> getMovieForWeek(Integer cinemaId) {
        LocalDate date = new LocalDate();
        return movieDao.findAllForWeek(cinemaId, date.toDateTimeAtCurrentTime().toDate(), date.plusDays(7).toDate());
    }

    @Override
    public List<Movie> getMovieByDate() {
        Calendar c = Calendar.getInstance();
        return movieDao.findByDate(c.getTime());
    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieDao.deleteById(movieId);
    }

    @Override
    public Optional<Movie> getById(Integer movieId) {
        return movieDao.findById(movieId);
    }


}
