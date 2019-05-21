/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaapp.backend.entitys;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Onak
 */
@Entity
@SequenceGenerator(name = "seat_sequence_generator", sequenceName = "seat_sequence", allocationSize = 1)
public class Seat implements Serializable {

    private Integer id;
    private Armchair armchair;
    private Employee employee;
    private Show show;
    private String status;
    private Float price;
    private String reliefType;
    
    @Id
    @GeneratedValue(generator = "seat_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "seat_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "status", length = 13)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = "relief_type", length = 6)
    public String getReliefType() {
        return reliefType;
    }

    public void setReliefType(String reliefType) {
        this.reliefType = reliefType;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "armchair_id")
    public Armchair getArmchair() {
        return armchair;
    }

    public void setArmchair(Armchair armchair) {
        this.armchair = armchair;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "show_id")
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat() {
    }

    public Seat(Armchair armchair, Employee employee, Show show, String status, Float price, String reliefType) {
        this.armchair = armchair;
        this.employee = employee;
        this.show = show;
        this.status = status;
        this.price = price;
        this.reliefType = reliefType;
    }
}
