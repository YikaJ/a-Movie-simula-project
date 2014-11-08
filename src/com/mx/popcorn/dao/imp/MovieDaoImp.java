package com.mx.popcorn.dao.imp;

import com.mx.popcorn.dao.MovieDao;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Page;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-10-28.
 */
@Repository
public class MovieDaoImp extends DaoSupportImp<Movie>  implements MovieDao {

    @Override
    public List<Movie> getMoviesForWhatCinemaAndWhen(Long id, Date date) {
        SQLQuery query = (SQLQuery) getSession().createSQLQuery("select m.* from movie m where id " +
                "in (select distinct s.movieId from schedule s where s.cinemaId = ? and s.showTime = ? order by s.createDate)")
                .setLong(0, id)
                .setDate(1, date);
        query.addEntity(Movie.class);
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public Page findGreaterSpecialDateAndHot(int pageNum, int num, Date specialDate) {
        Query query = getSession().createQuery("from Movie where showTime >= ?")
                .setDate(0, specialDate);
        query.setFirstResult((pageNum-1) * num);
        query.setMaxResults(num);
        query.setCacheable(true);
        List list = query.list();

        Long count = (Long) getSession().createQuery("select count(*) from Movie where showTime >= ?")
                .setDate(0, specialDate)
                .uniqueResult();
        return new Page(pageNum, num, count.intValue(), list);
    }

    @Override
    public Page findLowerSpecialDateAndHot(int pageNum, int pageSize, Date specialDate) {
        Query query = getSession().createQuery("from Movie where showTime < ?")
                .setDate(0, specialDate);
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        query.setCacheable(true);
        List list = query.list();

        Long count = (Long) getSession().createQuery("select count(*) from Movie where showTime < ?")
                .setDate(0, specialDate)
                .uniqueResult();
        return new Page(pageNum, pageSize, count.intValue(), list);
    }
}
