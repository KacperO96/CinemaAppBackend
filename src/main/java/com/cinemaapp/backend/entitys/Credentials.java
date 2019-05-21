package com.cinemaapp.backend.entitys;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "credentials_sequence_generator", sequenceName = "credentials_sequence", allocationSize = 1)
public class Credentials {
    private Integer id;
    private String login;
    private String password;
    private String role;

    @Id
    @GeneratedValue(generator = "credentials_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "credentials_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "login", length = 30, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", length = 15)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
