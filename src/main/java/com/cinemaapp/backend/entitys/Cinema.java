/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Onak
 */
@Entity
@SequenceGenerator(name = "cinema_sequence_generator", sequenceName = "cinema_sequence", allocationSize = 1)
public class Cinema implements Serializable {

    private Integer id;
    private String town;
    private String street;
    private String building_number;
    private String phone_number;
    private String email;

    @Id
    @GeneratedValue(generator = "cinema_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "cinema_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "town", length = 30)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "street", length = 30)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "building_number", length = 6)
    public String getBuilding_number() {
        return building_number;
    }

    public void setBuilding_number(String building_number) {
        this.building_number = building_number;
    }

    @Column(name = "phone_number", length = 12)
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Column(name = "email", length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
