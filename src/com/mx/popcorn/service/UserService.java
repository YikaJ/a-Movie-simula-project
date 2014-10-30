package com.mx.popcorn.service;

import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface UserService extends BaseService {


    void register(User model) throws Exception;
}
