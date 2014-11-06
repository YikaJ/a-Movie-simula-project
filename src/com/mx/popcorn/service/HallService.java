package com.mx.popcorn.service;

import com.mx.popcorn.domain.Hall;

import java.util.Set;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface HallService  extends BaseService{
    void addHalls(Set<Hall> halls);
}
