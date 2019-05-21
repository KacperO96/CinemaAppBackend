package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.VersionDao;
import com.cinemaapp.backend.entitys.Version;
import com.cinemaapp.backend.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {

    private final VersionDao versionDao;

    @Autowired
    public VersionServiceImpl(VersionDao versionDao) {
        this.versionDao = versionDao;
    }

    @Override
    public void addVersion(Version versionEntity) {
        versionDao.save(versionEntity);
    }

    @Override
    public List<Version> getAll() {
        return versionDao.findAll();
    }

    @Override
    public void deleteVersion(Integer VersionId) {
        versionDao.deleteById(VersionId);
    }
}
