package com.mx.popcorn.service.imp;

import com.mx.popcorn.configuration.Configuration;
import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Page;
import com.mx.popcorn.domain.Schedule;
import com.mx.popcorn.service.ScheduleService;
import com.mx.popcorn.utils.QueryHelper;
import com.mx.popcorn.utils.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class ScheduleServiceImp extends BaseServiceImp implements ScheduleService {

    @Override
    public Page getSchedulesForSpecialDate(int pageNum, Cinema cinema, Date date) {
        QueryHelper helper = new QueryHelper(Schedule.class, "s")
                .addWhereClause("cinemaId", cinema.getId())
                .addWhereClause("showTime", date);
        return scheduleDao.getPage(pageNum, helper, Configuration.getScheduleNum());
    }
}
