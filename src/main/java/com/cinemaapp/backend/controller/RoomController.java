package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Room;
import com.cinemaapp.backend.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/addOrUpdateRoom", method = RequestMethod.POST)
    public void addOrUpdateReservation(@RequestBody Room roomEntity) {
        roomService.addRoom(roomEntity);
    }


    @RequestMapping(value = "/user/getRoom", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", roomService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{cinemaId}/getRoomByCinemaId", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByCinemaId(@PathVariable("cinemaId") Integer cinemaId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", roomService.getAllByCinemaId(cinemaId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteRoom", method = RequestMethod.DELETE)
    public void deleteRoom(@RequestBody Integer value) {
        roomService.deleteRoom(value);
    }

    @RequestMapping(value = "/user/getRoomById/{roomId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getRoomById(@PathVariable("roomId") Integer roomId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", roomService.getRoomById(roomId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
