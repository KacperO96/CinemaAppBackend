package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT m FROM Show s INNER JOIN s.movie m WHERE s.room.cinema.id = :cinemaId AND s.date > :currentDate GROUP BY m ORDER BY COUNT(m) DESC")
    public List<Movie> findTopThree(@Param("cinemaId") Integer cinemaId, @Param("currentDate") Date currentDate, Pageable pageable);

    @Query(value = "SELECT DISTINCT m FROM Show s INNER JOIN s.movie m WHERE s.room.cinema.id = :cinemaId AND s.date BETWEEN :date AND :endDate")
    public List<Movie> findAllForWeek(@Param("cinemaId") Integer cinemaId, @Param("date") Date date, @Param("endDate") Date endDate);

    @Query(value = "SELECT m FROM Movie m WHERE m.sinceDate > :currentDatePlusWeek ORDER BY m.sinceDate")
    public List<Movie> findByDate(@Param("currentDatePlusWeek") Date currentDatePlusWeek);
}
