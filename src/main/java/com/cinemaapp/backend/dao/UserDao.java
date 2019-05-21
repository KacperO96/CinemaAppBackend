package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Credentials;
import com.cinemaapp.backend.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.credentials.login = :login")
    public User findByLogin(@Param("login") String login);

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM User u WHERE u.credentials.login = :login")
    public User findEmailByLogin(@Param("login") String login);

    @Query(value = "SELECT u FROM User u WHERE u.receiveInformation = true")
    public List<User> findUserToSendEmail();

}
