package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Armchair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArmchairDao extends JpaRepository<Armchair, Integer> {

    @Query(value = "SELECT ar FROM Armchair ar WHERE ar.room.id = :roomId")
    public List<Armchair> findAllByRoomId(@Param("roomId") Integer roomId);
}
