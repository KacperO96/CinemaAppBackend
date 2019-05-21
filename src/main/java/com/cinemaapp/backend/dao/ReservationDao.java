package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Reservation;
import com.cinemaapp.backend.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.user.credentials.login=:login")
    public List<Reservation> findAllByUserLogin(@Param("login") String login);

    @Query(value = "SELECT r FROM Reservation r WHERE r.confirmatoryCode=:confirmatoryCode")
    public List<Reservation> findbyConfirmatoryCode(@Param("confirmatoryCode") String confirmatoryCode);
}
