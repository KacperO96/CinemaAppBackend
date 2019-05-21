package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.ArmchairDao;
import com.cinemaapp.backend.entitys.Armchair;
import com.cinemaapp.backend.service.ArmchairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmchairServiceImpl implements ArmchairService {

    private final ArmchairDao armchairDao;

    @Autowired
    public ArmchairServiceImpl(ArmchairDao armchairDao) {
        this.armchairDao = armchairDao;
    }

    @Override
    public void addArmchair(Armchair armchairEntity) {
        armchairDao.save(armchairEntity);
    }

    @Override
    public void addListOfArmchair(List<Armchair> armchairList) {
        armchairDao.deleteAll(armchairDao.findAllByRoomId(armchairList.get(0).getRoom().getId()));
        armchairDao.saveAll(armchairList);
    }

    @Override
    public List<Armchair> getAll() {
        return armchairDao.findAll();
    }

    @Override
    public List<Armchair> getAllByRoomId(Integer roomId) {
        return armchairDao.findAllByRoomId(roomId);
    }

    @Override
    public void deleteArmchair(Integer armchairId) {
        armchairDao.deleteById(armchairId);
    }

    @Override
    public void deleteArmchairByRoomId(List<Armchair> armchairList) {
        armchairDao.deleteAll(armchairList);
    }
}
