package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionDao extends JpaRepository<Projection, Integer> {
}
