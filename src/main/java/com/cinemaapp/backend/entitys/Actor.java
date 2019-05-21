/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;

import com.cinemaapp.backend.tools.ActorId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 *
 * @author Onak
 */
@Entity
public class Actor implements Serializable {

    @EmbeddedId
    private ActorId id;

    public ActorId getId() {
        return id;
    }

    public void setId(ActorId id) {
        this.id = id;
    }

    public Actor() {
    }

}
