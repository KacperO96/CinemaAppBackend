package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.ProjectionDao;
import com.cinemaapp.backend.entitys.Projection;
import com.cinemaapp.backend.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionDao projectionDao;

    @Autowired
    public ProjectionServiceImpl(ProjectionDao projectionDao) {
        this.projectionDao = projectionDao;
    }

    @Override
    public void addProjection(Projection projectionEntity) {
        projectionDao.save(projectionEntity);
    }

    @Override
    public List<Projection> getAll() {
        return projectionDao.findAll();
    }

    @Override
    public void deleteProjection(Integer projectionId) {
        projectionDao.deleteById(projectionId);
    }
}
