package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.service.CinemaService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class CinemaServiceImp extends BaseServiceImp implements CinemaService{
    @Override
    public void register(Cinema model) {
        model.setCreateDate(new Date());
        cinemaDao.save(model);
    }

    @Override
    public Cinema login(String email, String password) {
        QueryHelper helper = new QueryHelper(Cinema.class, "c")
                .addWhereClause("email", email)
                .addWhereClause("password", password);
        return (Cinema) cinemaDao.findUnique(helper, true);
    }

    @Override
    public boolean isEmailExist(String email) {
        QueryHelper helper = new QueryHelper(Cinema.class, "c")
                .addWhereClause("email", email);
        int result = cinemaDao.getCount(helper);
        return result == 0 ? false : true;
    }
}
