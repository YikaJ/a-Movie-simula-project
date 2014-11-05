package com.mx.popcorn.service.imp;

import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Page;
import com.mx.popcorn.service.MovieService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2014-10-28.
 */
@Service
@Transactional
public class MovieServiceImp extends BaseServiceImp implements MovieService {

    @Override
    public void publishMovie(Movie model) {
        model.setCreateDate(new Date());
        movieDao.save(model);
    }

    @Override
    public Page getHotShowingMoviesOfIndex(int pageNum) {
        QueryHelper helper = new QueryHelper(Movie.class, "m");
        return movieDao.getPage(pageNum, helper, Configuration.getHotShowingMovieNumOfIndex());
    }

    @Override
    public Movie getMovie(Long movieId) {
        return movieDao.getById(movieId);
    }
}
