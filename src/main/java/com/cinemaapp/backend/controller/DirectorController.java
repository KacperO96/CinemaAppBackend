package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Director;
import com.cinemaapp.backend.service.DirectorService;
import com.cinemaapp.backend.tools.DirectorId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController()
@RequestMapping("/api")
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @RequestMapping(value = "/addOrUpdateDirector", method = RequestMethod.POST)
    public void addOrUpdateDirector(@RequestBody Director directorEntity) {
        directorService.addDirector(directorEntity);
    }

    @RequestMapping(value = "/user/getDirector", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", directorService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteDirector", method = RequestMethod.DELETE)
    public void deleteDirector(@RequestBody DirectorId value) {
        directorService.deleteDirector(value);
    }


}
