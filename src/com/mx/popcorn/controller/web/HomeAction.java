package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.BaseAction;
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
@Namespace("/home")
public class HomeAction extends BaseAction{

    private static final String ACTION_NAME_SPACE = "HomeIndex";

    public String index(){
        try{
            getActionContext().put("hotShowingMovies", movieService.getHotShowingMoviesOfIndex(pageNum));
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "/manage/index",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manage/index.jsp")})
    public String managerIndex(){
        return SUCCESS;
    }

    public static String getActionNameSpace() {
        return ACTION_NAME_SPACE;
    }
}
