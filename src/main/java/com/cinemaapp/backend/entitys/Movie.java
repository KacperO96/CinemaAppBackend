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
@SequenceGenerator(name = "movie_sequence_generator", sequenceName = "movie_sequence", allocationSize = 1)
public class Movie implements Serializable {

    private Integer id;
    private String title;
    private Integer duration;
    private String genre;
    private String urlImageLink;
    private String originalLanguage;
    private Date sinceDate;
    private String description;
    
    @Id
    @GeneratedValue(generator = "movie_sequence_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "movie_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", length = 60, unique = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Column(name = "genre", length = 20)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "since_date")
    public Date getSinceDate() {
        return sinceDate;
    }

    public void setSinceDate(Date sinceDate) {
        this.sinceDate = sinceDate;
    }

    @Column(name = "original_language", length = 30)
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "urlLink", length = 500)
    public String getUrlImageLink() {
        return urlImageLink;
    }

    public void setUrlImageLink(String urlImageLink) {
        this.urlImageLink = urlImageLink;
    }
}
