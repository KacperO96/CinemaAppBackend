package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Staff;

import java.util.List;

public interface StaffService {

    void addStaff(Staff staffEntity);

    List<Staff> getAll();

    List<Staff> getActorsByMovieId(Integer movieId);

    List<Staff> getDirectorsByMovieId(Integer movieId);

    void deleteStaff(Integer staffId);

}
