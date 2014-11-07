package com.mx.popcorn.service;

import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface ScheduleService extends BaseService {

    Page getSchedulesForSpecialDate(int pageNum, Cinema cinema, Date date);
}
