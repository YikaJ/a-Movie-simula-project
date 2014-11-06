package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.Hall;
import com.mx.popcorn.service.HallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class HallServiceImp extends BaseServiceImp implements HallService {
    @Override
    public void addHalls(Set<Hall> halls) {
        for (Hall hall : halls){
            hall.setCreateDate(new Date());
            hallDao.save(hall);
        }
    }
}
