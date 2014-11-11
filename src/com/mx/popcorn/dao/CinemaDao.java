package com.mx.popcorn.dao;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2014-10-28.
 */
public interface CinemaDao extends DaoSupport<Cinema>{

    Page findInCity(int pageNum, City city, int pageSize);

    List findInCitySimple(int pageNum, City city);
}
