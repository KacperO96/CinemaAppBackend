package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.EmployeeDao;
import com.cinemaapp.backend.entitys.Employee;
import com.cinemaapp.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employeeEntity) {
        employeeDao.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeByLogin(String login) {
        return employeeDao.findByLogin(login);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteById(employeeId);
    }


}
