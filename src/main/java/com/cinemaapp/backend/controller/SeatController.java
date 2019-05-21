package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Seat;
import com.cinemaapp.backend.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @RequestMapping(value = "/addOrUpdateSeat", method = RequestMethod.POST)
    public void addOrUpdateSeat(@RequestBody Seat seatEntity) {
        seatService.addSeat(seatEntity);
    }

    @RequestMapping(value = "/user/getSeat", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", seatService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getSeatByShowId/{showId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByShowId(@PathVariable("showId") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", seatService.getAllByShowId(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/sellTicket", method = RequestMethod.POST)
    public ResponseEntity changeStateOfSeat(@RequestBody List<Seat> seatEntity) {
        for (Seat seat: seatEntity) {
            if (seat.getStatus().equals("Zarezerwowane")) {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        for (Seat seat: seatEntity) {
            seat.setStatus("Zarezerwowane");
        }
        seatService.addListOfSeat(seatEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/confirmReservation", method = RequestMethod.POST)
    public ResponseEntity confirmReservation(@RequestBody List<Seat> seatEntity) {
        seatService.addListOfSeat(seatEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSeat", method = RequestMethod.DELETE)
    public void deleteSeat(@RequestBody Integer value) {
        seatService.deleteSeat(value);
    }


}
