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
@Table(name = "Users")
@SequenceGenerator(name = "user_sequence_generator", sequenceName = "user_sequence", allocationSize = 1)
public class User implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private String town;
    private String email;
    private Boolean receiveInformation;
    private Credentials credentials;

    @Id
    @GeneratedValue(generator = "user_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
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

    @Column(name = "town", length = 30)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "email", length = 254, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "receive_information")
    public Boolean getReceiveInformation() {
        return receiveInformation;
    }

    public void setReceiveInformation(Boolean receiveInformation) {
        this.receiveInformation = receiveInformation;
    }

    @OneToOne
    @JoinColumn(name = "credentials_id", nullable = false)
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}