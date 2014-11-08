package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String director;

    @Column(length = 100)
    private String scriptwriter;

    @Column(length = 100)
    private String alias;

    private Date showTime;

    @Column(length = 100)
    private String mainRole;

    @Column(length = 200)
    private String poster;

    @Column(length = 2000)
    private String introduce;

    private int filmTime;

    @Column(length = 20)
    private String language;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "Movie_MovieType", joinColumns = {@JoinColumn(name = "movieId")}, inverseJoinColumns = {@JoinColumn(name = "movieTypeId")})
    private Set<MovieType> movieTypes;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "Movie_MovieVersion", joinColumns = {@JoinColumn(name = "movieId")}, inverseJoinColumns = {@JoinColumn(name = "movieVersionId")})
    private Set<MovieVersion> movieVersions;

    @Column(length = 100)
    private String region;

    @OrderBy("time ASC")
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Schedule> schedules;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "Attention", joinColumns = {@JoinColumn(name = "movieId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<MovieComment> movieComments;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<MovieGrade> movieGrades;

    private int status = 0;

    private Date createDate;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director='" + director + '\'' +
                ", scriptwriter='" + scriptwriter + '\'' +
                ", alias='" + alias + '\'' +
                ", showTime=" + showTime +
                ", mainRole='" + mainRole + '\'' +
                ", poster='" + poster + '\'' +
                ", introduce='" + introduce + '\'' +
                ", filmTime=" + filmTime +
                ", language='" + language + '\'' +
                ", region='" + region + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JSON(serialize = false)
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @JSON(serialize = false)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @JSON(serialize = false)
    public Set<MovieComment> getMovieComments() {
        return movieComments;
    }

    public void setMovieComments(Set<MovieComment> movieComments) {
        this.movieComments = movieComments;
    }

    @JSON(serialize = false)
    public Set<MovieGrade> getMovieGrades() {
        return movieGrades;
    }

    public void setMovieGrades(Set<MovieGrade> movieGrades) {
        this.movieGrades = movieGrades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public int getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(int filmTime) {
        this.filmTime = filmTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JSON(serialize = false)
    public Set<MovieType> getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(Set<MovieType> movieTypes) {
        this.movieTypes = movieTypes;
    }

    @JSON(serialize = false)
    public Set<MovieVersion> getMovieVersions() {
        return movieVersions;
    }

    public void setMovieVersions(Set<MovieVersion> movieVersions) {
        this.movieVersions = movieVersions;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
