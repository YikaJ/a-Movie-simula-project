package com.mx.popcorn.service;

import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Page;

/**
 * Created by Administrator on 2014-10-28.
 */
public interface MovieService  extends BaseService{
    void publishMovie(Movie model);

    Page getHotShowingMoviesOfIndex(int pageNum);

    Movie getMovie(Long movieId);

    Page getNewMovieOnCinemaMovieStorage(int pageNum);
}
