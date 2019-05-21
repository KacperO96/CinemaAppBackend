package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffDao extends JpaRepository<Staff, Integer> {
    @Query(value = "SELECT s FROM Actor a INNER JOIN a.id.id_staff s INNER JOIN a.id.id_movie m WHERE m.id = :movieId")
    public List<Staff> findActorsByMovieId(@Param("movieId") Integer movieId);

    @Query(value = "SELECT s FROM Director d INNER JOIN d.id.id_staff s INNER JOIN d.id.id_movie m WHERE m.id = :movieId")
    public List<Staff> findDirectorsByMovieId(@Param("movieId") Integer movieId);
}
