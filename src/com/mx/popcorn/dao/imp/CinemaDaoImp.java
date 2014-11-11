package com.mx.popcorn.dao.imp;

import com.mx.popcorn.dao.CinemaDao;
import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.Page;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2014-10-28.
 */
@Repository
public class CinemaDaoImp extends DaoSupportImp<Cinema>  implements CinemaDao {

    @Override
    public Page findInCity(int pageNum, City city, int pageSize) {
        Query query = getSession().createQuery("from Cinema where districtId in (select id from District  where cityId = ?)")
                .setLong(0, city.getId());
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        query.setCacheable(true);
        List list = query.list();

        Long count = (Long) getSession().createQuery("select count(*) from Cinema where districtId in (select id from District  where cityId = ?)")
                .setLong(0, city.getId())
                .uniqueResult();
        return new Page(pageNum, pageSize, count.intValue(), list);
    }

    @Override
    public List findInCitySimple(int pageNum, City city) {
        return getSession().createQuery("from Cinema where districtId in (select id from District  where cityId = ?)")
                .setLong(0, city.getId())
                .list();
    }
}
