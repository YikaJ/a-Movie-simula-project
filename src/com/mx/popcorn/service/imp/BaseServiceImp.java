package com.mx.popcorn.service.imp;

import com.mx.popcorn.dao.*;
import com.mx.popcorn.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014-10-28.
 */
@Transactional
public class BaseServiceImp implements BaseService {

    /*==========================注入Dao============================*/
    @Resource
    protected CinemaCommentDao cinemaCommentDao;
    @Resource
    protected CinemaDao cinemaDao;
    @Resource
    protected CinemaGradeDao cinemaGradeDao;
    @Resource
    protected CityDao cityDao;
    @Resource
    protected DistrictDao districtDao;
    @Resource
    protected HallDao hallDao;
    @Resource
    protected MovieCommentDao movieCommentDao;
    @Resource
    protected MovieDao movieDao;
    @Resource
    protected MovieNewDao movieNewDao;
    @Resource
    protected MovieTypeDao movieTypeDao;
    @Resource
    protected MovieVersionDao movieVersionDao;
    @Resource
    protected ProvinceDao provinceDao;
    @Resource
    protected RegionDao regionDao;
    @Resource
    protected ScheduleDao scheduleDao;
    @Resource
    protected SeatDao seatDao;
    @Resource
    protected TicketOrderDao ticketOrderDao;
    @Resource
    protected UserDao userDao;


}
