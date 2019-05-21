package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.UserDao;
import com.cinemaapp.backend.entitys.User;
import com.cinemaapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> getUserToSendEmail() {
        return userDao.findUserToSendEmail();
    }

    @Override
    public String getEmailByLogin(String login) {
        if(userDao.findEmailByLogin(login) != null)
        return userDao.findEmailByLogin(login).getEmail();
        else
            return "";
    }

    @Override
    public boolean checkUserEmail(String email) {
        if(userDao.findByEmail(email) == null){
            return true;
        }
        return false;
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteById(userId);
    }

}
