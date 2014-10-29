package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class District extends Space {


    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Cinema> cinemas;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "district")
    private Set<User> users;




    @JSON(serialize = false)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @JSON(serialize = false)
    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
