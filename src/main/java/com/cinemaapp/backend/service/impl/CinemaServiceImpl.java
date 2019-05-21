package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.CinemaDao;
import com.cinemaapp.backend.entitys.Cinema;
import com.cinemaapp.backend.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaDao cinemaDao;

    @Autowired
    public CinemaServiceImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public void addCinema(Cinema cinemaEntity) {
        cinemaDao.save(cinemaEntity);
    }

    @Override
    public List<Cinema> getAll() {
        return cinemaDao.findAll();
    }

    @Override
    public List<Cinema> findAllByOrderByTownAsc() {
        return cinemaDao.findAll(new Sort(Sort.Direction.ASC, "town"));
    }

    @Override
    public Cinema getCinemaByEmployeeLogin(String login) {
        return cinemaDao.findByLogin(login);
    }

    @Override
    public void deleteCinema(Integer cinemaId) {
        cinemaDao.deleteById(cinemaId);
    }


}
