package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Cinema;
import org.apache.struts2.convention.annotation.*;
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

    /**
     * 影院主页，影院列表
     * @return
     */
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
