package com.mx.popcorn.interceptor;

import com.mx.popcorn.base.BaseAction;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.service.SpaceService;
import com.mx.popcorn.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

/**
 * 拦截cookie，自动登陆
 * Created by Administrator on 14-8-24.
 */

public class SpaceInterceptor extends AbstractInterceptor {


    @Resource
    private SpaceService spaceService;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (ServletActionContext.getRequest().getSession().getAttribute(BaseAction.SPACE_SESSION)!=null)
            return actionInvocation.invoke();
        System.out.println("=============================SpaceInterceptor===================================");
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("space")){
                    Long id = Long.parseLong(cookie.getValue());
                    City city = spaceService.getCityById(id);
                    if (city!=null){
                            ActionContext.getContext().getSession().put(BaseAction.SPACE_SESSION, city);
                    }
                }
            }
        }
        return actionInvocation.invoke();
    }
}