package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Hall;
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

}
