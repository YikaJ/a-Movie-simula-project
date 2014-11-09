package com.mx.popcorn.service.imp;

import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Page;
import com.mx.popcorn.domain.Schedule;
import com.mx.popcorn.service.MovieService;
import com.mx.popcorn.utils.QueryHelper;
import com.mx.popcorn.utils.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Administrator on 2014-10-28.
 */
@Service
@Transactional
public class MovieServiceImp extends BaseServiceImp implements MovieService {

    @Override
    public void publishMovie(Movie model) throws RuntimeException{
        model.setCreateDate(new Date());
        movieDao.save(model);
    }

    @Override
    public Page getHotShowingMoviesOfIndex(int pageNum) throws RuntimeException {
        QueryHelper helper = new QueryHelper(Movie.class, "m");
        return movieDao.getPage(pageNum, helper, Configuration.getHotShowingMovieNumOfIndex());
    }

    @Override
    public Movie getMovie(Long movieId) throws RuntimeException {
        return movieDao.getById(movieId);
    }

    @Override
    public Page getNewMovieOnCinemaMovieStorage(int pageNum) throws RuntimeException {
        QueryHelper helper = new QueryHelper(Movie.class, "m")
                .addOrderByClause("showTime", false);
        return movieDao.getPage(pageNum, helper, Configuration.getNewMovieNumOnCinema());
    }

    @Override
    public List getMoviesForSchedule(Date date) {
        QueryHelper helper = new QueryHelper(Movie.class, "m")
                .addWhereClause("showTime", WebUtils.getSpecialTime(date, -Configuration.getIsScheduleableNum()), date);
        return movieDao.find(helper, true);
    }

    /**
     * 什么影院的什么时间上映的电影
     * @param cinema
     * @param date
     * @return
     */
    @Override
    public List getMoviesForCinemaSchedule(Cinema cinema, Date date) {
        List<Movie> movies = movieDao.getMoviesForWhatCinemaAndWhen(cinema.getId(), date);
        for (Movie movie : movies){
            QueryHelper helper = new QueryHelper(Schedule.class, "s")
                    .addWhereClause("movieId", movie.getId())
                    .addWhereClause("showTime", date);
            movie.setSchedules(scheduleDao.find(helper, true));
        }
        return movies;
    }

    @Override
    public Page getPreviewMovieFormIndex(int pageNum)  {
        try {
            return movieDao.findGreaterSpecialDateAndHot(pageNum, Configuration.getMovieNumOfIndex(),
                    WebUtils.getSpecialTime(WebUtils.getSpecialFormToDate(new Date()), 1));
        } catch (ParseException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public Page getHotMovieFormIndex(int pageNum) {
        try {
            return movieDao.findLowerSpecialDateAndHot(pageNum, Configuration.getMovieNumOfIndex(),
                    WebUtils.getSpecialTime(WebUtils.getSpecialFormToDate(new Date()), 1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page getHotMovieFormCinemaIndex(int pageNum) {
        try {
            return movieDao.findLowerSpecialDateAndHot(pageNum, Configuration.getMovieNumOfCinemaIndex(),
                    WebUtils.getSpecialTime(WebUtils.getSpecialFormToDate(new Date()), 1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
