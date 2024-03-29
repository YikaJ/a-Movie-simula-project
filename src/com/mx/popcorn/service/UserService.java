package com.mx.popcorn.service;

import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface UserService extends BaseService {


    User register(User model) throws Exception;

    boolean isEmptyOfNick(String nick);

    boolean isEmptyOfEmail(String email);

    User login(String email, String password);

    User findByEmail(String email);

    User updatePicture(String picture, User user);

    User getUserById(Long id);

    User updateUserInfo(User model);

    User updatePassword(User user, String password);
}
