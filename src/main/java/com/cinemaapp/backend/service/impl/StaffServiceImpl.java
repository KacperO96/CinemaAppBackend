package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.StaffDao;
import com.cinemaapp.backend.entitys.Staff;
import com.cinemaapp.backend.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    @Autowired
    public StaffServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public void addStaff(Staff staffEntity) {
        staffDao.save(staffEntity);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Staff> getActorsByMovieId(Integer movieId) {
        return staffDao.findActorsByMovieId(movieId);
    }

    @Override
    public List<Staff> getDirectorsByMovieId(Integer movieId) {
        return staffDao.findDirectorsByMovieId(movieId);
    }

    @Override
    public void deleteStaff(Integer staffId) {
        staffDao.deleteById(staffId);
    }


}
