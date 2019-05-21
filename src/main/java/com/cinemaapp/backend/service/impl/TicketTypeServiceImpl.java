package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.TicketTypeDao;
import com.cinemaapp.backend.entitys.TicketType;
import com.cinemaapp.backend.entitys.TicketWithProjection;
import com.cinemaapp.backend.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    private final TicketTypeDao ticketTypeDao;

    @Autowired
    public TicketTypeServiceImpl(TicketTypeDao ticketTypeDao) {
        this.ticketTypeDao = ticketTypeDao;
    }

    @Override
    public void addTicketType(TicketType ticketTypeEntity) {
        ticketTypeDao.save(ticketTypeEntity);
    }

    @Override
    public List<TicketWithProjection> getTicketWithProjection() {
        return ticketTypeDao.findTicketWithProjection();
    }

    @Override
    public List<TicketWithProjection> getTicketByProjection(String projection) {
        return ticketTypeDao.findTicketTypeByProjection(projection);
    }

    @Override
    public List<TicketType> getAll() {
        return ticketTypeDao.findAll();
    }

    @Override
    public void deleteTicketType(Integer ticketTypeId) {
        ticketTypeDao.deleteById(ticketTypeId);
    }
}
