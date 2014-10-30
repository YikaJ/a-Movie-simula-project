package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Movie;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@Namespace("/movie")
public class MovieAction  extends ModelDrivenBaseAction<Movie> {

    @Action(value = "index", results = @Result(location = "/movie/movieInformation.jsp"))
    public String index(){
        try {
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

}
