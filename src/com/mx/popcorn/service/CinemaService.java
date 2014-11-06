package com.mx.popcorn.service;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Hall;

import java.util.Set;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface CinemaService extends BaseService{
    void register(Cinema model);

    Cinema login(String email, String password);

    boolean isEmailExist(String email);

    Cinema getCinemaById(Long cinemaId);
}
