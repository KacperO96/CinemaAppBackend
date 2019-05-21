package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Reservation;
import com.cinemaapp.backend.entitys.User;

import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservationEntity);

    void addFewReservation(List<Reservation> reservationEntity);

    List<Reservation> getAll();

    List<Reservation> getAllByUserLogin(String login);

    List<Reservation> getByConfirmatoryCode(String confirmatoryCode);

    void deleteReservation(Integer reservationId);

    void deleteReservationList(List<Reservation> reservation);

}
