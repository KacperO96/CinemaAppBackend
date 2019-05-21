package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.SeatDao;
import com.cinemaapp.backend.entitys.Seat;
import com.cinemaapp.backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatDao seatDao;

    @Autowired
    public SeatServiceImpl(SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    @Override
    public void addSeat(Seat seatEntity) {
        seatDao.save(seatEntity);
    }

    @Override
    public void addListOfSeat(List<Seat> listOfSeat) {
        seatDao.saveAll(listOfSeat);
    }


    @Override
    public List<Seat> getAll() {
        return seatDao.findAll();
    }

    @Override
    public List<Seat> getSeatsById(List<Integer> ids) {
        return seatDao.findAllById(ids);
    }

    @Override
    public Seat getSeatById(Integer id) {
        return seatDao.findById(id).get();
    }

    @Override
    public List<Seat> getAllByShowId(Integer showId) {
        return seatDao.findSeatByShowIdQuery(showId);
    }

    @Override
    public void deleteSeat(Integer seatId) {
        seatDao.deleteById(seatId);
    }


}
