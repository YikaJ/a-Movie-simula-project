package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;
import com.mx.popcorn.service.UserService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class UserServiceImp extends BaseServiceImp implements UserService {


    @Override
    public void register(User model) throws RuntimeException {
        model.setCreateDate(new Date());
        userDao.save(model);
    }

    @Override
    public boolean isEmptyOfNick(String nick) throws RuntimeException  {
        QueryHelper helper = new QueryHelper(User.class, "u")
                .addWhereClause("nick", nick);
        int result = userDao.getCount(helper);
        if (result == 0)
            return true;
        return false;
    }

    @Override
    public boolean isEmptyOfEmail(String email) throws RuntimeException  {
        QueryHelper helper = new QueryHelper(User.class, "u")
                .addWhereClause("email", email);
        int result = userDao.getCount(helper);
        if (result == 0)
            return true;
        return false;
    }

    @Override
    public User login(String email, String password) throws RuntimeException  {
        QueryHelper helper = new QueryHelper(User.class, "u")
                .addWhereClause("email", email)
                .addWhereClause("password", password);
        return (User) userDao.findUnique(helper, true);
    }

    @Override
    public User findByEmail(String email)  throws RuntimeException {
        QueryHelper helper = new QueryHelper(User.class, "u")
                .addWhereClause("email", email);
        return (User) userDao.findUnique(helper, true);
    }
}
