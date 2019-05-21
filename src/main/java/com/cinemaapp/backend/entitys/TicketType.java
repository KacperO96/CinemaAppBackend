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
@SequenceGenerator(name = "ticket_sequence_generator", sequenceName = "ticket_sequence", allocationSize = 1)
public class TicketType implements Serializable {

    private Integer id;
    private String type;
    private Float price;

    @Id
    @GeneratedValue(generator = "ticket_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "ticket_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", length = 6)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
