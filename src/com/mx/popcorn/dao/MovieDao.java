package com.mx.popcorn.dao;

import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-10-28.
 */
public interface MovieDao extends DaoSupport<Movie> {
    List<Movie> getMoviesForWhatCinemaAndWhen(Long id, Date date);

    Page findGreaterSpecialDateAndHot(int pageNum, int num, Date specialDate);

    Page findLowerSpecialDateAndHot(int pageNum, int pageSize, Date specialDate);
}
