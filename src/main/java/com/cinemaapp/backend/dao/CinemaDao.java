package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CinemaDao extends JpaRepository<Cinema, Integer> {

    @Query(value = "SELECT e.cinema FROM Employee e WHERE e.credentials.login = :login")
    public Cinema findByLogin(@Param("login") String login);
}
