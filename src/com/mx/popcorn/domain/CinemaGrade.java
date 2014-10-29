package com.mx.popcorn.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class CinemaGrade extends Grade{

    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
