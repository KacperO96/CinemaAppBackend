package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.TicketType;
import com.cinemaapp.backend.entitys.TicketWithProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketTypeDao extends JpaRepository<TicketType, Integer> {

    @Query(value = "SELECT new com.cinemaapp.backend.entitys.TicketWithProjection(tt.type, pr.type, pr.price + tt.price) FROM TicketType tt, Projection  pr WHERE pr.type = :projection ORDER BY pr.type, tt.type DESC")
    public List<TicketWithProjection> findTicketTypeByProjection(@Param("projection") String projection);

    @Query(value = "SELECT new com.cinemaapp.backend.entitys.TicketWithProjection(tt.type, pr.type, pr.price + tt.price) FROM TicketType tt, Projection  pr ORDER BY pr.type, tt.type DESC")
    public List<TicketWithProjection> findTicketWithProjection();
}
