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
@SequenceGenerator(name = "armchair_sequence_generator", sequenceName = "armchair_sequence", allocationSize = 1)
public class Armchair implements Serializable {

    private Integer id;
    private Room room;
    private String row;
    private String seat_number;
    private String armchair_type;
    private Integer coordinates_X;
    private Integer coordinates_Y;

    @Id
    @GeneratedValue(generator = "armchair_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "armchair_id")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "row", length = 1)
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    @Column(name = "seat_number", length = 2)
    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    @Column(name = "armchair_type", length = 10)
    public String getArmchair_type() {
        return armchair_type;
    }

    public void setArmchair_type(String armchair_type) {
        this.armchair_type = armchair_type;
    }

    @Column(name = "coordinates_X")
    public Integer getCoordinates_X() {
        return coordinates_X;
    }

    public void setCoordinates_X(Integer coordinates_X) {
        this.coordinates_X = coordinates_X;
    }

    @Column(name = "coordinates_Y")
    public Integer getCoordinates_Y() {
        return coordinates_Y;
    }

    public void setCoordinates_Y(Integer coordinates_Y) {
        this.coordinates_Y = coordinates_Y;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
     
    
    
}
