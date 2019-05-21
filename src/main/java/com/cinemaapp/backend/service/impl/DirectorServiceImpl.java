package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.DirectorDao;
import com.cinemaapp.backend.entitys.Director;
import com.cinemaapp.backend.service.DirectorService;
import com.cinemaapp.backend.tools.DirectorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorDao directorDao;

    @Autowired
    public DirectorServiceImpl(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
    public void addDirector(Director directorEntity) {
        directorDao.save(directorEntity);
    }

    @Override
    public List<Director> getAll() {
        return directorDao.findAll();
    }

    @Override
    public void deleteDirector(DirectorId directorId) {
        directorDao.deleteById(directorId);
    }

}
