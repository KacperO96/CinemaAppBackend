package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Staff;
import com.cinemaapp.backend.service.StaffService;
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
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(value = "/addOrUpdateStaff", method = RequestMethod.POST)
    public void addOrUpdateStaff(@RequestBody Staff staffEntity) {
        staffService.addStaff(staffEntity);
    }


    @RequestMapping(value = "/user/getStaff", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", staffService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getActorsByMovieId/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getStaffByMovieId(@PathVariable("movieId") Integer movieId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", staffService.getActorsByMovieId(movieId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getDirectorsByMovieId/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getDirectorsByMovieId(@PathVariable("movieId") Integer movieId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", staffService.getDirectorsByMovieId(movieId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteStaff", method = RequestMethod.DELETE)
    public void deleteStaff(@RequestBody Integer value) {
        staffService.deleteStaff(value);
    }


}
