package com.mx.popcorn.base;


import com.mx.popcorn.domain.Schedule;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.service.*;
import com.mx.popcorn.service.imp.GradeServiceImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    @Resource
    protected TypeService typeService;

     /*===============================常量===============================*/
    public static final String USER_SESSION = "user";
    public static final String CINEMA_SESSION = "cinema";
    public static final String REFERER_SESSION = "referer";
    public static final String JSON_STATUS_HEADER = "response";

    /*=============================返回值=================================*/
    public static final String JSON = "json";
    public static final String FAILURE = "failure";
    public static final String FIND_FAILURE = "find_failure";
    public static final String FORBID = "forbid";
    public static final String HOME = "home";
    public static final String FORM_ERROR = "form_error";

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
    protected String previous;

    public String getPrevious() {
        return previous;
    }

    public boolean getStatus() {
        return status;
    }

    /*==========================JSON=============================*/
    public Map<String, Object> jsonMap = new HashMap<String, Object>();
    public Map<String, Object> errorMap = new HashMap<String, Object>();
    public Map<String, Object> msgMap = new HashMap<String, Object>();

    public Map<String, Object> getMsgMap() {
        return msgMap;
    }

    public Map<String, Object> getErrorMap() {
        return errorMap;
    }

    public Map<String, Object> getJsonMap() {
        return jsonMap;
    }

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

    /**
     * 获得Context对象
     */
    public ActionContext getActionContext(){
        return ActionContext.getContext();
    }

    /*=======================================================*/

}
