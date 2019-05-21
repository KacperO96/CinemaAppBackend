package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionDao extends JpaRepository<Version, Integer> {
}
