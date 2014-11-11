package com.mx.popcorn.service.imp;

import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.domain.*;
import com.mx.popcorn.service.CinemaService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class CinemaServiceImp extends BaseServiceImp implements CinemaService{
    @Override
    public void register(Cinema model) throws RuntimeException{
        model.setCreateDate(new Date());
        cinemaDao.save(model);
    }

    @Override
    public Cinema login(String email, String password) throws RuntimeException {
        QueryHelper helper = new QueryHelper(Cinema.class, "c")
                .addWhereClause("email", email)
                .addWhereClause("password", password);
        return (Cinema) cinemaDao.findUnique(helper, true);
    }

    @Override
    public boolean isEmailExist(String email) throws RuntimeException {
        QueryHelper helper = new QueryHelper(Cinema.class, "c")
                .addWhereClause("email", email);
        int result = cinemaDao.getCount(helper);
        return result == 0 ? false : true;
    }

    @Override
    public Cinema getCinemaById(Long cinemaId) throws RuntimeException {
        return cinemaDao.getById(cinemaId);
    }

    @Deprecated
    @Override
    public Page getAllCinema(int pageNum) {
        QueryHelper helper = new QueryHelper(Cinema.class, "c");
        return cinemaDao.getPage(pageNum, helper, Configuration.getCinemaNum());
    }

    @Override
    public Page getAllCinemaOfDistrict(int pageNum, District district) {
        if (district == null)
            return null;
        QueryHelper helper = new QueryHelper(Cinema.class, "c")
                .addWhereClause("districtId", district.getId());
        return cinemaDao.getPage(pageNum, helper, Configuration.getCinemaNum());
    }

    @Override
    public Page getAllCinemaOfCity(int pageNum, City city) {
        if (city == null)
        return null;
        return cinemaDao.findInCity(pageNum, city, Configuration.getCinemaNum());
    }

}
