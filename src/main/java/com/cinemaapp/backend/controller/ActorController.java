package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Actor;
import com.cinemaapp.backend.service.ActorService;
import com.cinemaapp.backend.tools.ActorId;
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
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = "/addOrUpdateActor", method = RequestMethod.POST)
    public void addOrUpdateActor(@RequestBody Actor actorEntity) {
        actorService.addActor(actorEntity);
    }


    @RequestMapping(value = "/user/getActor", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", actorService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteActor", method = RequestMethod.DELETE)
    public void deleteActor(@RequestBody ActorId value) {
        actorService.deleteActor(value);
    }


}
