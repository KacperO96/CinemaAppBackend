package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Room;

import java.util.List;

public interface RoomService {

    void addRoom(Room roomEntity);

    List<Room> getAll();

    List<Room> getAllByCinemaId(Integer cinemaId);

    void deleteRoom(Integer roomId);

    Room getRoomById(Integer roomId);
}
