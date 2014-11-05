package com.mx.popcorn.service;

import com.mx.popcorn.domain.Cinema;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface CinemaService extends BaseService{
    void register(Cinema model);

    Cinema login(String email, String password);

    boolean isEmailExist(String email);
}
