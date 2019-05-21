package com.cinemaapp.backend.tools;

import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.entitys.Staff;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActorId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
    private Staff id_staff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", nullable = false, insertable = false, updatable = false)
    private Movie id_movie;

    public ActorId() {
    }

    public ActorId(Staff id_staff, Movie id_movie) {
        this.id_staff = id_staff;
        this.id_movie = id_movie;
    }

    public Staff getId_staff() {
        return id_staff;
    }

    public void setId_staff(Staff id_staff) {
        this.id_staff = id_staff;
    }

    public Movie getId_movie() {
        return id_movie;
    }

    public void setId_movie(Movie id_movie) {
        this.id_movie = id_movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorId actorId = (ActorId) o;
        return Objects.equals(id_staff, actorId.id_staff) &&
                Objects.equals(id_movie, actorId.id_movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_staff, id_movie);
    }
}
