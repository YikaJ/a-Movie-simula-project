package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Cinema;
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
@Namespace("/cinema")
public class CinemaAction extends ModelDrivenBaseAction<Cinema>{

    private static final String ACTION_NAME_SPACE = "CinemaIndex";

    @Action(value = "index",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/cinema/cinemaList.jsp")})
    public String index(){
        try {
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
