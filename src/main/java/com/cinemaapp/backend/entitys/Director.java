/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;


import com.cinemaapp.backend.tools.DirectorId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 *
 * @author Onak
 */
@Entity
public class Director implements Serializable {

    @EmbeddedId
    private DirectorId id;

    public DirectorId getId() {
        return id;
    }

    public void setId(DirectorId id) {
        this.id = id;
    }

    public Director() {
    }
}
