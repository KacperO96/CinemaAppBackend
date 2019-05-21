package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatDao extends JpaRepository<Seat, Integer> {

//    @Query(value = "SELECT s FROM Seat s WHERE s.show.id = :showId")
//    public List<Seat> findAllByShowId(@Param("showId") Integer showId);

    @Query(value = "SELECT s FROM Seat s WHERE s.show.id = :showId")
    public List<Seat> findSeatByShowIdQuery(@Param("showId") Integer showId);

    @Query(value = "SELECT s FROM Seat s WHERE s.show.id IN :showId")
    public List<Seat> findSeatsById(@Param("showId") List<Integer> showId);


}
