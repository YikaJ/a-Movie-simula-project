package com.mx.popcorn.base;


import com.mx.popcorn.domain.Schedule;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.service.*;
import com.mx.popcorn.service.imp.GradeServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 14-8-16.
 */
public class BaseAction extends ActionSupport {

    /*=========================注入service==============================*/

    @Resource
    protected CinemaService cinemaService;
    @Resource
    protected CommentService commentService;
    @Resource
    protected GradeService gradeService;
    @Resource
    protected HallService hallService;
    @Resource
    protected MovieService movieService;
    @Resource
    protected MovieNewService movieNewService;
    @Resource
    protected OrderService orderService;
    @Resource
    protected ScheduleService scheduleService;
    @Resource
    protected SpaceService spaceService;
    @Resource
    protected UserService userService;

     /*===============================常量===============================*/
    public static final String USER_SESSION = "user";
    public static final String REFERER = "referer";

    /*=============================返回值=================================*/
    public static final String NOTHING = "nothing";
    public static final String FORBID = "forbid";
    public static final String HOME = "home";

    /*=========================分页支持==============================*/
    protected int pageNum = 1;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /*=========================状态==============================*/
    protected boolean status = true;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /*==========================工具=============================*/
    /**
     * 从session里获得当前回话的user
     * @return
     */
    public User getCurrentUser(){
        return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
    }

    /**
     * 获得请求的IP地址
     * @return
     */
    public String getRequestIP(){
        return ServletActionContext.getRequest().getRemoteAddr();
    }

    /**
     * 获得session对象
     * @return
     */
    public HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 获得request对象
     * @return
     */
    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }

    /**
     * 获得response对象
     * @return
     */
    public HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }


    /*=======================================================*/

}
