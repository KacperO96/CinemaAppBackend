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
@SequenceGenerator(name = "reservation_sequence_generator", sequenceName = "reservation_sequence", allocationSize = 1)
public class Reservation implements Serializable {

    private Integer id;
    private Seat seat;
    private User user;
    private String confirmatoryCode;
    
    @Id
    @GeneratedValue(generator = "reservation_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "reservation_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "confirmatory_code", length = 50)
    public String getConfirmatoryCode() {
        return confirmatoryCode;
    }

    public void setConfirmatoryCode(String confirmatoryCode) {
        this.confirmatoryCode = confirmatoryCode;
    }

    @ManyToOne
    @JoinColumn(name = "seat_id")
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
}
