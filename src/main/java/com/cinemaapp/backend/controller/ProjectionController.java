package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Projection;
import com.cinemaapp.backend.service.ProjectionService;
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
public class ProjectionController {

    private final ProjectionService projectionService;

    @Autowired
    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @RequestMapping(value = "/addOrUpdateProjection", method = RequestMethod.POST)
    public void addOrUpdateProjection(@RequestBody Projection projectionEntity) {
        projectionService.addProjection(projectionEntity);
    }

    @RequestMapping(value = "/user/getProjection", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", projectionService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteProjection", method = RequestMethod.DELETE)
    public void deleteProjection(@RequestBody Integer value) {
        projectionService.deleteProjection(value);
    }


}
