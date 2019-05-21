/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Onak
 */
@Entity
@SequenceGenerator(name = "employee_sequence_generator", sequenceName = "employee_sequence", allocationSize = 1)
public class Employee implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Cinema cinema;
    private Credentials credentials;
    private boolean isActive = true;

    @Id
    @GeneratedValue(generator = "employee_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @OneToOne
    @JoinColumn(name = "credentials_id", nullable = false)
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
