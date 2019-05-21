package com.cinemaapp.backend.service;

import com.cinemaapp.backend.entitys.Credentials;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CredentialsService {

    public void addCredential(Credentials credentialsEntity);

    public boolean checkUserLogin(String login);

}
