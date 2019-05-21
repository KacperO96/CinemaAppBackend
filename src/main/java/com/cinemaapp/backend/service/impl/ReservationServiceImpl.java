package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.ReservationDao;
import com.cinemaapp.backend.entitys.Reservation;
import com.cinemaapp.backend.entitys.User;
import com.cinemaapp.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;

    @Autowired
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public void addReservation(Reservation reservationEntity) {
        reservationDao.save(reservationEntity);
    }

    @Override
    public void addFewReservation(List<Reservation> reservationEntity) {
        reservationDao.saveAll(reservationEntity);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationDao.findAll();
    }

    @Override
    public List<Reservation> getAllByUserLogin(String login) {
        return reservationDao.findAllByUserLogin(login);
    }

    @Override
    public List<Reservation> getByConfirmatoryCode(String confirmatoryCode) {
        return reservationDao.findbyConfirmatoryCode(confirmatoryCode);
    }

    @Override
    public void deleteReservation(Integer reservationId) {
        reservationDao.deleteById(reservationId);
    }

    @Override
    public void deleteReservationList(List<Reservation> reservation) {
        reservationDao.deleteAll(reservation);
    }


}
