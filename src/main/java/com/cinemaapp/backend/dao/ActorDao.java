package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Actor;
import com.cinemaapp.backend.tools.ActorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, ActorId> {

}
