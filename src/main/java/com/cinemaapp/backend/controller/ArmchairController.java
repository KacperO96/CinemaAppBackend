package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Armchair;
import com.cinemaapp.backend.service.ArmchairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class ArmchairController {

    private final ArmchairService armchairService;

    @Autowired
    public ArmchairController(ArmchairService armchairService) {
        this.armchairService = armchairService;
    }

    @RequestMapping(value = "/addOrUpdateArmchair", method = RequestMethod.POST)
    public void addOrUpdateArmchair(@RequestBody List<Armchair> armchairEntityList) {
        armchairService.addListOfArmchair(armchairEntityList);
    }

    @RequestMapping(value = "/user/getArmchair", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", armchairService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getArmchairByRoomId", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByRoomId(@RequestParam Integer roomId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", armchairService.getAllByRoomId(roomId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteArmchairList", method = RequestMethod.GET)
    public void deleteArmchairList(Integer roomId) {
        List<Armchair> armchairList = new ArrayList<>();
        armchairList = armchairService.getAllByRoomId(roomId);
        armchairService.deleteArmchairByRoomId(armchairList);
        Map<String, Object> map = new HashMap<>();
    }

    @RequestMapping(value = "/deleteArmchair", method = RequestMethod.DELETE)
    public void deleteArmchair(@RequestBody Integer value) {
        armchairService.deleteArmchair(value);
    }


}
