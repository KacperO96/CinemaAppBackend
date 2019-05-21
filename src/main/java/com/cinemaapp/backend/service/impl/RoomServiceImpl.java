package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.RoomDao;
import com.cinemaapp.backend.entitys.Room;
import com.cinemaapp.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void addRoom(Room roomEntity) {
        roomDao.save(roomEntity);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.findAll();
    }

    @Override
    public void deleteRoom(Integer roomId) {
        roomDao.deleteById(roomId);
    }

    @Override
    public Room getRoomById(Integer roomId) {
        return roomDao.findById(roomId).get();
    }

    @Override
    public List<Room> getAllByCinemaId(Integer cinemaId) {
        return roomDao.findRoomByCinemaId(cinemaId);
    }

}
