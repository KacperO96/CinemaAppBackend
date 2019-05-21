package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Projection;

import java.util.List;

public interface ProjectionService {

    void addProjection(Projection projectionEntity);

    List<Projection> getAll();

    void deleteProjection(Integer projectionId);
}
