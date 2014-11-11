package com.mx.popcorn.service;

import com.mx.popcorn.domain.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface CinemaService extends BaseService{
    void register(Cinema model);

    Cinema login(String email, String password);

    boolean isEmailExist(String email);

    Cinema getCinemaById(Long cinemaId);

    @Deprecated
    Page getAllCinema(int pageNum);

    Page getAllCinemaOfDistrict(int pageNum, District district);

    Page getAllCinemaOfCity(int pageNum, City city);

    List getAllCinemaOfCityNotPage(int pageNum, City city);
}
