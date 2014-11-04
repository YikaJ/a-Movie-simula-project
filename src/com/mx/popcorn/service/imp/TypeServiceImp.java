package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.MovieType;
import com.mx.popcorn.domain.MovieVersion;
import com.mx.popcorn.service.BaseService;
import com.mx.popcorn.service.TypeService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-11-3.
 */
@Service
@Transactional
public class TypeServiceImp extends BaseServiceImp implements TypeService {

    @Override
    public List getAllMovieType() {
        QueryHelper helper = new QueryHelper(MovieType.class, "mt");
        return movieTypeDao.find(helper, true);
    }

    @Override
    public List getAllMovieVersion() {
        QueryHelper helper = new QueryHelper(MovieVersion.class, "mt");
        return movieTypeDao.find(helper, true);
    }

    @Override
    public MovieType getMovieType(Long movieTypeId) {
        return movieTypeDao.getById(movieTypeId);
    }

    @Override
    public MovieVersion getMovieVersion(Long movieVersionId) {
        return movieVersionDao.getById(movieVersionId);
    }

    @Override
    public void addMovieType(MovieType movieType) {
        movieType.setCreateDate(new Date());
        movieTypeDao.save(movieType);
    }

    @Override
    public void addMovieVersion(MovieVersion movieVersion) {
        movieVersion.setCreateDate(new Date());
        movieVersionDao.save(movieVersion);
    }
}
