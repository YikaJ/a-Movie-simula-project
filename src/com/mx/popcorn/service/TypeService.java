package com.mx.popcorn.service;

import com.mx.popcorn.domain.MovieType;
import com.mx.popcorn.domain.MovieVersion;

import java.util.List;

/**
 * Created by Administrator on 2014-11-3.
 */
public interface TypeService extends BaseService {
    List getAllMovieType();

    List getAllMovieVersion();

    MovieType getMovieType(Long movieTypeId);

    MovieVersion getMovieVersion(Long movieVersionId);

    void addMovieType(MovieType movieType);

    void addMovieVersion(MovieVersion movieVersion);
}
