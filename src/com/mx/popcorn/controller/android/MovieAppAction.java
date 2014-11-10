package com.mx.popcorn.controller.android;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Movie;
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

    @Action(value = "index",
            results = {@Result(name = SUCCESS, type = JSON, params ={"root", "jsonMap"})})
    public String index(){
        try{
            System.out.println("-------------------------movie app index------------------------------");
            jsonMap.put("movies", movieService.getAppIndexMovie(pageNum));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }

}
