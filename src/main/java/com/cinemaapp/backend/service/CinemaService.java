package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Cinema;

import java.util.List;

public interface CinemaService {

    void addCinema(Cinema cinemaEntity);

    List<Cinema> getAll();

    List<Cinema> findAllByOrderByTownAsc();

    Cinema getCinemaByEmployeeLogin(String login);

    void deleteCinema(Integer cinemaId);

}
