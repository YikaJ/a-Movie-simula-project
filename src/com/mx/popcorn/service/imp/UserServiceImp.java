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
    public void register(User model) throws Exception {
        QueryHelper helper = new QueryHelper(User.class, "u")
                .addWhereClause("email", model.getEmail())
                .addWhereClause("password", model.getPassword());
        User user = (User) userDao.findUnique(helper, true);
        if (user != null){
            QueryHelper helper2 = new QueryHelper(User.class, QueryHelper.UPDATE,"u")
                    .addWhereClause("id", user.getId());
            throw new UserExitException("用户已存在！！");
        }

        model.setCreateDate(new Date());
        userDao.save(model);
    }
}
