package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {

    void addSeat(Seat seatEntity);

    void addListOfSeat(List<Seat> listOfSeat);

    List<Seat> getAll();

    List<Seat> getSeatsById(List<Integer> ids);

    Seat getSeatById(Integer id);

    List<Seat> getAllByShowId(Integer showId);

    void deleteSeat(Integer seatId);

}
