package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Cinema;
import com.mx.popcorn.domain.Hall;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.Schedule;
import com.mx.popcorn.utils.WebUtils;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/schedule")
public class ScheduleAction  extends ModelDrivenBaseAction<Schedule> {

    private Long movieId;
    private String[] hallIds;
    private String[] prices;
    private String[] times;
    private int dayType;


    @Action(value = "/cinema/manage/schedule/publishSchedule",
            results = {@Result(name = SUCCESS, type = "redirectAction", params = {"actionName", "scheduleManage", "namespace", "/cinema/manage", "dayType", "${dayType}"})},
            interceptorRefs = {@InterceptorRef("cinemaPrivilegeInterceptorStack")})
    public String publishSchedule(){
        try{
            Cinema cinema = (Cinema) getSession().getAttribute(CINEMA_SESSION);
            Movie movie = movieService.getMovie(movieId);
            if (movie == null)
                return FIND_FAILURE;
            List<Schedule> schedules = new ArrayList<Schedule>();
            for (int i=0; i<hallIds.length; i++){
                Schedule schedule = new Schedule();
                schedule.setCreateDate(new Date());
                Hall hall = hallService.getHallById(Long.valueOf(hallIds[i].trim()), cinema);
                if (hall == null)
                    return FIND_FAILURE;
                schedule.setHall(hall);
                schedule.setCinema(cinema);
                schedule.setMovie(movie);
                schedule.setPrice(Float.parseFloat(prices[i].trim()));
                schedule.setShowTime(model.getShowTime());
                schedule.setTime(times[i].trim());
                schedule.setWeek(WebUtils.getSpecialDate(model.getShowTime(), "EEEE"));
                schedules.add(schedule);
            }
            scheduleService.addSchedules(schedules);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    public int getDayType() {
        return dayType;
    }

    public void setDayType(int dayType) {
        this.dayType = dayType;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String[] getHallIds() {
        return hallIds;
    }

    public void setHallIds(String[] hallIds) {
        this.hallIds = hallIds;
    }

    public String[] getPrices() {
        return prices;
    }

    public void setPrices(String[] prices) {
        this.prices = prices;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }
}
