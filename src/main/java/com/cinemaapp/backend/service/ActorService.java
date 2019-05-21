package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Actor;
import com.cinemaapp.backend.tools.ActorId;

import java.util.List;

public interface ActorService {

    void addActor(Actor actorEntity);

    List<Actor> getAll();

    void deleteActor(ActorId actorId);

}
