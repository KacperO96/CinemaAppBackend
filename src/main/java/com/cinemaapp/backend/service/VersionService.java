package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Version;

import java.util.List;

public interface VersionService {

    void addVersion(Version versionEntity);

    List<Version> getAll();

    void deleteVersion(Integer versionId);
}
