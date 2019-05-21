package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShowDao extends JpaRepository<Show, Integer> {

    @Query(value = "SELECT s FROM Show s WHERE s.room.cinema.id = :cinemaId AND s.date > :date ORDER BY s.date")
    public List<Show> findAll(@Param("cinemaId") Integer cinemaId, @Param("date") Date date);

    @Query(value = "SELECT s FROM Show s WHERE s.room.cinema.id = :cinemaId AND s.date BETWEEN :date AND :endDate ORDER BY s.date")
    public List<Show> findAllByDate(@Param("cinemaId") Integer cinemaId, @Param("date") Date date, @Param("endDate") Date endDate);

    @Query(value = "SELECT s FROM Show s WHERE s.movie.id = :movieId AND s.room.cinema.id = :cinemaId AND s.date BETWEEN :date AND :endDate ORDER BY s.date")
    public List<Show> findByMovieId(@Param("cinemaId") Integer cinemaId, @Param("movieId") Integer movieId, @Param("date") Date date, @Param("endDate") Date endDate);
}
