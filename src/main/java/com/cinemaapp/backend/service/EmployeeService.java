package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employeeEntity);

    public List<Employee> getAll();

    public Employee getEmployeeByLogin(String login);

    public void deleteEmployee(Integer employeeId);

}
