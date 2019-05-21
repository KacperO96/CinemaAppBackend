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
@SequenceGenerator(name = "version_sequence_generator", sequenceName = "version_sequence", allocationSize = 1)
public class Version implements Serializable {

    private Integer id;
    private String type;

    @Id
    @GeneratedValue(generator = "version_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "version_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}