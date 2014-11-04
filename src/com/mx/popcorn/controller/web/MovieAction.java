package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.MovieType;
import com.mx.popcorn.domain.MovieVersion;
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
    private String[] type;
    private String[] version;

    @Action(value = "index", results = @Result(location = "/WEB-INF/jsp/customer/movie/movieList.jsp"))
    public String index(){
        try {
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "/manage/movie/addMovieUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manage/movie/addMovieUI.jsp")})
    public String addMovieUI(){
        try{
            getActionContext().put("movieType", typeService.getAllMovieType());
            getActionContext().put("movieVersion", typeService.getAllMovieVersion());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "publishMovie", results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manage/index.jsp")})
    public String publishMovie(){

        System.out.println(model.toString());
        System.out.println(type);
        System.out.println(version);
        /*try{
            if (movieTypeId == null || movieVersionId == null)
                return ERROR;
            MovieType movieType = typeService.getMovieType(movieTypeId);
            MovieVersion movieVersion = typeService.getMovieVersion(movieVersionId);
            if (movieType == null || movieVersion == null)
                return  ERROR;
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }*/
        return null;
    }

    public static String getActionNameSpace() {
        return ACTION_NAME_SPACE;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public void setVersion(String[] version) {
        this.version = version;
    }
}
