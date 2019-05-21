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
 * @author Onak
 */
@Entity
@SequenceGenerator(name = "show_sequence_generator", sequenceName = "show_sequence", allocationSize = 1)
public class Show implements Serializable {

    private Integer id;
    private Date date;
    private Room room;
    private Movie movie;
    private String projection;
    private String version;

    @Id
    @GeneratedValue(generator = "show_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "show_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Column(name = "projection", length = 2)
    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    @Column(name = "version", length = 10)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
