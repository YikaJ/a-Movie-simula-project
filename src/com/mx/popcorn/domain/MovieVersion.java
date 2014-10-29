package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class MovieVersion extends Type{

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "movieVersions")
    private Set<Movie> movies;

    @JSON(serialize = false)
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
