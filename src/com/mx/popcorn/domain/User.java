package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 20)
    private String nick;

    private boolean gender;

    @Column(length = 200)
    private String picture;

    private Date birthday;

    @Column(length = 1000)
    private String signature;

    @ManyToOne
    @JoinColumn(name = "districtId")
    private District district;

    private Date createDate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<TicketOrder> ticketOrders;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Movie> movies;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Cinema> cinemas;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<MovieComment> movieComments;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<CinemaComment> cinemaComments;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<MovieGrade> movieGrades;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<CinemaGrade> cinemaGrades;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JSON(serialize = false)
    public Set<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(Set<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }

    @JSON(serialize = false)
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @JSON(serialize = false)
    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @JSON(serialize = false)
    public Set<MovieComment> getMovieComments() {
        return movieComments;
    }

    public void setMovieComments(Set<MovieComment> movieComments) {
        this.movieComments = movieComments;
    }

    @JSON(serialize = false)
    public Set<CinemaComment> getCinemaComments() {
        return cinemaComments;
    }

    public void setCinemaComments(Set<CinemaComment> cinemaComments) {
        this.cinemaComments = cinemaComments;
    }

    @JSON(serialize = false)
    public Set<MovieGrade> getMovieGrades() {
        return movieGrades;
    }

    public void setMovieGrades(Set<MovieGrade> movieGrades) {
        this.movieGrades = movieGrades;
    }

    @JSON(serialize = false)
    public Set<CinemaGrade> getCinemaGrades() {
        return cinemaGrades;
    }

    public void setCinemaGrades(Set<CinemaGrade> cinemaGrades) {
        this.cinemaGrades = cinemaGrades;
    }
}
