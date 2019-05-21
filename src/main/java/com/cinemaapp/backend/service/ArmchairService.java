package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Armchair;

import java.util.List;

public interface ArmchairService {

    void addArmchair(Armchair armchairEntity);

    void addListOfArmchair(List<Armchair> armchairList);

    List<Armchair> getAll();

    List<Armchair> getAllByRoomId(Integer roomId);

    void deleteArmchairByRoomId(List<Armchair> armchairList);

    void deleteArmchair(Integer armchairId);
}
