package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Director;
import com.cinemaapp.backend.tools.DirectorId;

import java.util.List;

public interface DirectorService {

    public void addDirector(Director directorEntity);

    public List<Director> getAll();

    public void deleteDirector(DirectorId directorId);

}
