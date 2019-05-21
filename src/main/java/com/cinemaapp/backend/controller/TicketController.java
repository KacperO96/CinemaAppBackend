package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.TicketType;
import com.cinemaapp.backend.service.TicketTypeService;
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
public class TicketController {

    private final TicketTypeService ticketTypeService;

    @Autowired
    public TicketController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @RequestMapping(value = "/addOrUpdateTicketType", method = RequestMethod.POST)
    public void addOrUpdateTicket(@RequestBody TicketType ticketTypeEntity) {
        ticketTypeService.addTicketType(ticketTypeEntity);
    }


    @RequestMapping(value = "/user/getTicketType", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", ticketTypeService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getTicketWithProjection", method = RequestMethod.GET)
    public ResponseEntity<Map> getTicketWithProjection() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", ticketTypeService.getTicketWithProjection());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getTicketByProjection", method = RequestMethod.GET)
    public ResponseEntity<Map> getTicketByProjection(String projection) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", ticketTypeService.getTicketByProjection(projection));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteTicketType", method = RequestMethod.DELETE)
    public void deleteTicket(@RequestBody Integer value) {
        ticketTypeService.deleteTicketType(value);
    }


}
