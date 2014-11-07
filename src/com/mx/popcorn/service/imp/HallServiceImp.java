package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Hall;
import com.mx.popcorn.service.HallService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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

    @Override
    public List getHallForCinema(Cinema cinema) {
        QueryHelper helper = new QueryHelper(Hall.class, "h")
                .addWhereClause("cinemaId", cinema.getId());
        return hallDao.find(helper, true);
    }

    @Override
    public Hall getHallById(Long id, Cinema cinema) {
        QueryHelper helper = new QueryHelper(Hall.class, "c")
                .addWhereClause("id", id)
                .addWhereClause("cinemaId", cinema.getId());
        return (Hall) hallDao.findUnique(helper, true);
    }
}
