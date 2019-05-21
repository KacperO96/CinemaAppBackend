package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.ShowDao;
import com.cinemaapp.backend.entitys.Show;
import com.cinemaapp.backend.service.ShowService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowDao showDao;

    private final Integer TWO_DAY = 2;
    private final Integer ONE_DAY = 1;
    private final Integer SEVEN_DAY = 7;

    @Autowired
    public ShowServiceImpl(ShowDao showDao) {
        this.showDao = showDao;
    }

    @Override
    public void addShow(Show showEntity) {
        showDao.save(showEntity);
    }

    @Override
    public List<Show> getAll() {
        return showDao.findAll();
    }

    @Override
    public List<Show> getByDate(Integer cinemaId, Date date) {
        LocalDate endDate = new LocalDate(date);
        return showDao.findAllByDate(cinemaId, date, endDate.plusDays(ONE_DAY).toDate());
    }

    @Override
    public List<Show> getByDateForWeek(Integer cinemaId, Date date) {
        LocalDate endDate = new LocalDate(date);
        return showDao.findAllByDate(cinemaId, date, endDate.plusDays(SEVEN_DAY).toDate());
    }

    @Override
    public List<Show> getByMovieId(Integer cinemaId, Integer movieId) {
        LocalDate date = new LocalDate();
        return showDao.findByMovieId(cinemaId, movieId, date.toDate(), date.plusDays(TWO_DAY).toDate());
    }

    @Override
    public void deleteShow(Integer showId) {
        showDao.deleteById(showId);
    }


}
