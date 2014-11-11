package com.mx.popcorn.controller.android;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.utils.TextTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/app/movie")
public class MovieAppAction extends ModelDrivenBaseAction<Movie> {


    private String space;

    @Action(value = "index",
            results = {@Result(name = SUCCESS, type = JSON, params ={"root", "jsonMap"})})
    public String index(){
        try{
            System.out.println("-------------------------movie app index------------------------------");
            jsonMap.put("movies", movieService.getAppIndexMovie(pageNum));
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }

    @Action(value = "showCinemaList",
            results = {@Result(name = SUCCESS, type = JSON, params ={"root", "jsonMap"}),
                                @Result(name = FAILURE, type = JSON, params ={"root", "jsonMap"})})
    public String showCinemaList(){
        try{
            System.out.println("-----------------show CinemaList---------------------------");
            if (TextTools.isEmpty(space)){
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FIND_FAILURE;
            }
            System.out.println(space);
            City city = spaceService.getCityByName(space);
            if (city==null){
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FAILURE;
            }
            jsonMap.put("cinemas", cinemaService.getAllCinemaOfCityNotPage(pageNum, city));
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }


    public void setSpace(String space) {
        this.space = space;
    }
}
