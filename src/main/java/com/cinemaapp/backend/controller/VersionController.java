package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Version;
import com.cinemaapp.backend.service.VersionService;
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
public class VersionController {

    private final VersionService versionService;

    @Autowired
    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    @RequestMapping(value = "/addOrUpdateVersion", method = RequestMethod.POST)
    public void addOrUpdateVersion(@RequestBody Version versionEntity) {
        versionService.addVersion(versionEntity);
    }


    @RequestMapping(value = "/user/getVersion", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", versionService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteVersion", method = RequestMethod.DELETE)
    public void deleteVersion(@RequestBody Integer value) {
        versionService.deleteVersion(value);
    }


}
