package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.service.MovieService;
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
}
