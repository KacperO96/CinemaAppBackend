package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.ActorDao;
import com.cinemaapp.backend.entitys.Actor;
import com.cinemaapp.backend.service.ActorService;
import com.cinemaapp.backend.tools.ActorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorDao actorDao;

    @Autowired
    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public void addActor(Actor actorEntity) {
        actorDao.save(actorEntity);
    }

    @Override
    public List<Actor> getAll() {
        return actorDao.findAll();
    }

    @Override
    public void deleteActor(ActorId actorId) {
        actorDao.deleteById(actorId);
    }

}
