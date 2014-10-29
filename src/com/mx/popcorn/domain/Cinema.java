package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class Cinema {


    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(length = 50)
    private String workTime;

    @Column(length = 40)
    private String telephone;

    @Column(length = 100)
    private String address;

    @Column(length = 50)
    private String company;

    @ManyToOne
    @JoinColumn(name = "districtId")
    private District district;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "Often", joinColumns = {@JoinColumn(name = "cinemaId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "cinema")
    private Set<CinemaComment> cinemaComments;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "cinema")
    private Set<CinemaGrade> cinemaGrades;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "cinema")
    private Set<Hall> halls;

    private Date createDate;


    @JSON(serialize = false)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @JSON(serialize = false)
    public Set<CinemaComment> getCinemaComments() {
        return cinemaComments;
    }

    public void setCinemaComments(Set<CinemaComment> cinemaComments) {
        this.cinemaComments = cinemaComments;
    }

    @JSON(serialize = false)
    public Set<CinemaGrade> getCinemaGrades() {
        return cinemaGrades;
    }

    public void setCinemaGrades(Set<CinemaGrade> cinemaGrades) {
        this.cinemaGrades = cinemaGrades;
    }

    @JSON(serialize = false)
    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
}
