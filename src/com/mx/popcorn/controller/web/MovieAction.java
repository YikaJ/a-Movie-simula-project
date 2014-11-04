package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Movie;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/movie")
public class MovieAction  extends ModelDrivenBaseAction<Movie> {

    private static final String ACTION_NAME_SPACE = "MovieIndex";

    @Action(value = "index", results = @Result(location = "/WEB-INF/jsp/movie/movieList.jsp"))
    public String index(){
        try {
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "addMovieUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manager/movie/addMovieUI.jsp")})
    public String addMovieUI(){
        try{
            getActionContext().put("movieType", typeService.getAllMovieType());
            getActionContext().put("movieVersion", typeService.getAllMovieVersion());
            getActionContext().put("region", spaceService.getAllRegion());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }


    public String publishMovie(){
        try{

            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    public static String getActionNameSpace() {
        return ACTION_NAME_SPACE;
    }
}
