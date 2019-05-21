package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.TicketType;
import com.cinemaapp.backend.entitys.TicketWithProjection;

import java.util.List;

public interface TicketTypeService {

    void addTicketType(TicketType ticketTypeEntity);

    List<TicketWithProjection> getTicketWithProjection();

    List<TicketWithProjection> getTicketByProjection(String projection);

    List<TicketType> getAll();

    void deleteTicketType(Integer ticketTypeId);
}
