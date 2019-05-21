package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Armchair;
import com.cinemaapp.backend.entitys.Seat;
import com.cinemaapp.backend.entitys.Show;
import com.cinemaapp.backend.service.ArmchairService;
import com.cinemaapp.backend.service.SeatService;
import com.cinemaapp.backend.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.*;

@RestController()
@RequestMapping("/api")
public class ShowController {

    private final ShowService showService;

    private final SeatService seatService;

    private final ArmchairService armchairService;

    @Autowired
    public ShowController(ShowService showService, SeatService seatService, ArmchairService armchairService) {
        this.showService = showService;
        this.seatService = seatService;
        this.armchairService = armchairService;
    }

    @RequestMapping(value = "/addOrUpdateShow", method = RequestMethod.POST)
    public void addOrUpdateShow(@RequestBody Show showEntity) {
        if(showEntity.getId() == null) {
            List<Armchair> tempArmchair = armchairService.getAllByRoomId(showEntity.getRoom().getId());
            List<Seat> tempSeat = new ArrayList<>();
            showService.addShow(showEntity);
            for (Armchair armchair : tempArmchair) {
                tempSeat.add(new Seat(armchair,null,showEntity, "wolne",null,null));
            }
            seatService.addListOfSeat(tempSeat);
        }
        else {
            showService.addShow(showEntity);
        }
    }


    @RequestMapping(value = "/user/getShow", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", showService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{cinemaId}/getShowByDate", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByDate(@PathVariable("cinemaId") Integer cinemaId, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", showService.getByDate(cinemaId, date));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{cinemaId}/getShowByDateForWeek", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByDateForWeek(@PathVariable("cinemaId") Integer cinemaId, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", showService.getByDateForWeek(cinemaId, date));
//        map.put("data", showService.getByDateForWeek(cinemaId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{cinemaId}/getShowByMovieId/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getShowByMovieId(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("movieId") Integer movieId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", showService.getByMovieId(cinemaId, movieId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteShow", method = RequestMethod.DELETE)
    public void deleteShow(@RequestBody Integer value) {
        showService.deleteShow(value);
    }


}
