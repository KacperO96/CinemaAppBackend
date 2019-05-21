/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Onak
 */
@Entity
@SequenceGenerator(name = "staff_sequence_generator", sequenceName = "staff_sequence", allocationSize = 1)
public class Staff implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    
    @Id
    @GeneratedValue(generator = "staff_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "staff_id")
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

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
