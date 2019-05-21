package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Director;
import com.cinemaapp.backend.tools.DirectorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorDao extends JpaRepository<Director, DirectorId> {

}
