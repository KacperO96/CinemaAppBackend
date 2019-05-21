package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Cinema;
import com.cinemaapp.backend.service.CinemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @RequestMapping(value = "/addOrUpdateCinema", method = RequestMethod.POST)
    public void addOrUpdateCinema(@RequestBody Cinema cinemaEntity) {
        cinemaService.addCinema(cinemaEntity);
    }

    @RequestMapping(value = "/employee/getCinemaByEmployeeLogin", method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaByEmployeeLogin(String login) {
        return new ResponseEntity<>(cinemaService.getCinemaByEmployeeLogin(login), HttpStatus.OK);
    }


    @RequestMapping(value = "/user/getCinema", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", cinemaService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getCinemaByTownAsc", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByTownAsc() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", cinemaService.findAllByOrderByTownAsc());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteCinema", method = RequestMethod.DELETE)
    public void deleteCinema(@RequestBody Integer value) {
        cinemaService.deleteCinema(value);
    }


}
