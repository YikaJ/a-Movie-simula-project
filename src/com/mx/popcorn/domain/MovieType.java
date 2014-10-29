package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class MovieType extends Type{

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "movieTypes")
    private Set<Movie> movies;


    @JSON(serialize = false)
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
