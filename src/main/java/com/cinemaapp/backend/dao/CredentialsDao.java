package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CredentialsDao extends JpaRepository<Credentials, Integer> {

    @Query(value = "SELECT c FROM Credentials c WHERE c.login = :login")
    public Credentials findByLogin(@Param("login") String login);
}
