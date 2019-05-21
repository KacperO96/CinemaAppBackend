package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.User;
import com.cinemaapp.backend.service.CredentialsService;
import com.cinemaapp.backend.service.UserService;
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
public class UserController {

    private final UserService userService;

    private final CredentialsService credentialsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, CredentialsService credentialsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.credentialsService = credentialsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/user/addOrUpdateUser", method = RequestMethod.POST)
    public ResponseEntity<Map> addOrUpdateUser(@RequestBody User userEntity) {
        Map<String, Object> map = new HashMap<>();
        if (!credentialsService.checkUserLogin(userEntity.getCredentials().getLogin())) {
            map.put("error", "Login jest już użyty. Proszę wybrać inny login");
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }
        if (!userService.checkUserEmail(userEntity.getEmail())) {
            map.put("error", "Email jest już użyty. Proszę wybrać inny email");
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }
        userEntity.getCredentials().setRole("USER");
        userEntity.getCredentials().setPassword(bCryptPasswordEncoder.encode(userEntity.getCredentials().getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(userEntity.getCredentials().getPassword()));
        credentialsService.addCredential(userEntity.getCredentials());
        userService.addUser(userEntity);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getEmailByLogin", method = RequestMethod.GET)
    public ResponseEntity<String> getEmailByLogin(String login) {
        return new ResponseEntity<>(userService.getEmailByLogin(login), HttpStatus.OK);
    }

    @RequestMapping(value = "/loggedUser/updateUserPassword", method = RequestMethod.POST)
    public ResponseEntity updateUserPassword(String login, String password) {
        User user = userService.getUserByLogin(login);
        if (user != null) {
            user.getCredentials().setPassword(bCryptPasswordEncoder.encode(password));
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/loggedUser/getUserByLogin", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(String login) {
        return new ResponseEntity<>(userService.getUserByLogin(login), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody Integer value) {
        userService.deleteUser(value);
    }


}
