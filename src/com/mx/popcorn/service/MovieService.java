package com.mx.popcorn.service;

import com.mx.popcorn.domain.Movie;

/**
 * Created by Administrator on 2014-10-28.
 */
public interface MovieService  extends BaseService{
    void publishMovie(Movie model);
}
