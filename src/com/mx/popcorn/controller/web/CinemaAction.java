package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.utils.TextTools;
import com.mx.popcorn.utils.WebUtils;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/cinema")
public class CinemaAction extends ModelDrivenBaseAction<Cinema>{

    private static final String ACTION_NAME_SPACE = "CinemaIndex";
    private static final int TODAY = 0;
    private static final int TOMORROW = 1;
    private static final int AFTER_TOMORROW = 2;
    private int dayType = TODAY;
    private Long cinemaId;

    /**
     * 影院主页，影院列表
     * @return
     */
    @Action(value = "index",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/cinema/cinemaList.jsp")})
    public String index(){
        try {
            getActionContext().put("movies", movieService.getHotMovieFormCinemaIndex(pageNum));
            getActionContext().put("cinemas", cinemaService.getAllCinema(pageNum));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "/cinema/manage/movieStorage",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/cinema/home/index.jsp")},
            interceptorRefs = {@InterceptorRef("cinemaPrivilegeInterceptorStack")})
    public String movieStorage(){
        try {
            getActionContext().put("newMovie", movieService.getNewMovieOnCinemaMovieStorage(pageNum));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 影院注册页面
     * @return
     */
    @Action(value = "/cinema/manage/registerUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/cinema/home/register.jsp")})
    public String registerUI(){
        try {
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }


    @Action(value = "/cinema/manage/register",
            results = {@Result(name = SUCCESS, type = "redirectAction", params={"actionName", "loginUI"}),
                                @Result(name = INPUT, location = "/WEB-INF/jsp/cinema/home/register.jsp")})
    public String register(){
        try {
            if (cinemaService.isEmailExist(model.getEmail())){
                addFieldError("account", "该邮箱已经注册过了");
                return INPUT;
            }
            cinemaService.register(model);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "/cinema/manage/loginUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/cinema/home/login.jsp")})
    public String loginUI(){
        try{
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "/cinema/manage/login",
            results = {@Result(name = SUCCESS, type = "redirectAction", params = {"actionName", "movieStorage"}),
                                @Result(name = INPUT, location = "/WEB-INF/jsp/cinema/home/login.jsp")})
    public String login(){
        try{
            Cinema cinema = cinemaService.login(model.getEmail(), model.getPassword());
            if (cinema == null){
                addFieldError("account", "账号或者密码错误!");
                return INPUT;
            }
            getSession().setAttribute(CINEMA_SESSION, cinema);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "/cinema/manage/scheduleManage",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/cinema/schedule/schedule.jsp")},
            interceptorRefs = {@InterceptorRef("cinemaPrivilegeInterceptorStack")})
    public String scheduleManage(){
        try{
            Cinema cinema = (Cinema) getSession().getAttribute(CINEMA_SESSION);
            Date date = new Date();
            Date tom = WebUtils.getSpecialTime(date, 1);
            Date after_tom = WebUtils.getSpecialTime(date, 2);
            getActionContext().put("today", WebUtils.getSpecialDate(date, "MM-dd")+WebUtils.getSpecialDate(date, "EEEE"));
            getActionContext().put("tom", WebUtils.getSpecialDate(tom, "MM-dd")+WebUtils.getSpecialDate(tom, "EEEE"));
            getActionContext().put("after_tom", WebUtils.getSpecialDate(after_tom, "MM-dd")+WebUtils.getSpecialDate(after_tom, "EEEE"));
            getActionContext().put("halls", hallService.getHallForCinema(cinema));
                switch (dayType){
                    case TOMORROW:
                        getActionContext().put("baseDate", WebUtils.getSpecialDate(tom, "yyyy-MM-dd"));
                        getActionContext().put("schedulesOfMovie", movieService.getMoviesForCinemaSchedule(cinema, tom));
//                        getActionContext().put("schedules", scheduleService.getSchedulesForSpecialDate(pageNum, cinema, tom));
                        getActionContext().put("movies", movieService.getMoviesForSchedule(tom));
                        break;
                    case AFTER_TOMORROW:
                        getActionContext().put("baseDate", WebUtils.getSpecialDate(after_tom, "yyyy-MM-dd"));
                        getActionContext().put("schedulesOfMovie", movieService.getMoviesForCinemaSchedule(cinema, after_tom));
                        getActionContext().put("movies", movieService.getMoviesForSchedule(after_tom));
                        break;
                    default:
                        getActionContext().put("baseDate", WebUtils.getSpecialDate(date, "yyyy-MM-dd"));
                        getActionContext().put("schedulesOfMovie", movieService.getMoviesForCinemaSchedule(cinema, date));
                        getActionContext().put("movies", movieService.getMoviesForSchedule(date));
                }
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "cinemaInfo",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/cinema/cinemaInfo.jsp")})
    public String cinemaInfo(){
        try {
            if (cinemaId == null)
                return FIND_FAILURE;
            Cinema cinema = cinemaService.getCinemaById(cinemaId);
            if (cinema == null)
                return FIND_FAILURE;
            getActionContext().put("cinema", cinema);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }



    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getDayType() {
        return dayType;
    }

    public void setDayType(int dayType) {
        this.dayType = dayType;
    }

    public static String getActionNameSpace() {
        return ACTION_NAME_SPACE;
    }

}
