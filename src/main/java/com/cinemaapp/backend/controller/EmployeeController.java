package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Employee;
import com.cinemaapp.backend.service.CredentialsService;
import com.cinemaapp.backend.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final CredentialsService credentialsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CredentialsService credentialsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeService = employeeService;
        this.credentialsService = credentialsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/addOrUpdateEmployee", method = RequestMethod.POST)
    public ResponseEntity<Map> addOrUpdateEmployee(@RequestBody Employee employeeEntity) {
        Map<String, Object> map = new HashMap<>();
        if (employeeEntity.getCredentials().getId() == null) {
            if (!credentialsService.checkUserLogin(employeeEntity.getCredentials().getLogin())) {
                map.put("error", "Login jest już użyty. Proszę wybrać inny login");
                return new ResponseEntity<>(map, HttpStatus.CONFLICT);
            }
            employeeEntity.getCredentials().setPassword(bCryptPasswordEncoder.encode(employeeEntity.getCredentials().getPassword()));
        }
        credentialsService.addCredential(employeeEntity.getCredentials());
        employeeService.addEmployee(employeeEntity);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/loggedEmployee/updateEmployeePassword", method = RequestMethod.POST)
    public ResponseEntity updateUserPassword(String login, String password) {
        Employee employee = employeeService.getEmployeeByLogin(login);
        if (employee != null) {
            employee.getCredentials().setPassword(bCryptPasswordEncoder.encode(password));
            employeeService.addEmployee(employee);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/loggedEmployee/getEmployeeByLogin", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeByLogin(String login) {
        return new ResponseEntity<>(employeeService.getEmployeeByLogin(login), HttpStatus.OK);
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", employeeService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestBody Integer value) {
        employeeService.deleteEmployee(value);
    }


}
