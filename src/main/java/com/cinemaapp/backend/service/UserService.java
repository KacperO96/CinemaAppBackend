package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.User;

import java.util.List;

public interface UserService {

    void addUser(User userEntity);

    List<User> getAll();

    List<User> getUserToSendEmail();

    String getEmailByLogin(String login);

    boolean checkUserEmail(String email);

    User getUserByLogin(String login);

    void deleteUser(Integer userId);

}
