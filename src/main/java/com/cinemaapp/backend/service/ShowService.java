package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Show;

import java.util.Date;
import java.util.List;

public interface ShowService {

    void addShow(Show showEntity);

    List<Show> getAll();

    List<Show> getByDate(Integer cinemaId, Date date);

    List<Show> getByDateForWeek(Integer cinemaId, Date date);

    List<Show> getByMovieId(Integer cinemaId, Integer movieId);

    void deleteShow(Integer showId);

}
