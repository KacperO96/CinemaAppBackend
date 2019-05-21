package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.dao.CredentialsDao;
import com.cinemaapp.backend.entitys.Credentials;
import com.cinemaapp.backend.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CredentialsServiceImpl implements CredentialsService, UserDetailsService {

    private final CredentialsDao credentialsDao;

    @Autowired
    public CredentialsServiceImpl(CredentialsDao credentialsDao) {
        this.credentialsDao = credentialsDao;
    }


    @Override
    public void addCredential(Credentials credentialsEntity) {
        credentialsDao.save(credentialsEntity);
    }

    @Override
    public boolean checkUserLogin(String login) {
        return credentialsDao.findByLogin(login) == null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials applicationUser;
        applicationUser = credentialsDao.findByLogin(username);
        if (applicationUser != null) {
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_" + applicationUser.getRole());
            return new User(applicationUser.getLogin(), applicationUser.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
