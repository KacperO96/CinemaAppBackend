package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Integer> {
//    public List<Room> findRoomByCinemaId(Integer cinemaId);

    @Query(value = "SELECT r FROM Room r WHERE r.cinema.id = :cinemaId")
    public List<Room> findRoomByCinemaId(@Param("cinemaId") Integer cinemaId);

}
