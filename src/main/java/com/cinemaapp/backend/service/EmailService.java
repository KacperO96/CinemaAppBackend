package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.entitys.Seat;

import java.util.List;

public interface EmailService {
    void sendNewMovieMessage(String to, String subject, Movie movie);
    void sendConfCodeMessage(Seat seat, String to, String subject, List<String> reservation, String confCode, String town);
}
