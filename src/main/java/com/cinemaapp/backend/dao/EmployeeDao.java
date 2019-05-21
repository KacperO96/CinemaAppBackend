package com.cinemaapp.backend.dao;

import com.cinemaapp.backend.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e FROM Employee e WHERE e.credentials.login = :login")
    public Employee findByLogin(@Param("login") String login);
}
