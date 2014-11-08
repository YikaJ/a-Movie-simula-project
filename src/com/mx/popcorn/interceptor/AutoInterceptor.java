package com.mx.popcorn.interceptor;

import com.mx.popcorn.base.BaseAction;
import com.mx.popcorn.domain.User;
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

public class AutoInterceptor extends AbstractInterceptor {

    @Resource
    private UserService userService;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (ServletActionContext.getRequest().getSession().getAttribute(BaseAction.USER_SESSION)!=null)
            return actionInvocation.invoke();
        System.out.println("=============================Interceptor===================================");
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("autoLoginTo")){
                    String email = cookie.getValue().split("_")[0];
                    String password = cookie.getValue().split("_")[1];
                    email = new String(new BASE64Decoder().decodeBuffer(email));
                    password = new String(new BASE64Decoder().decodeBuffer(password));
                    User user = userService.findByEmail(email);
                    if (user!=null){
                        if (password.equals(user.getPassword())){
                            ActionContext.getContext().getSession().put(BaseAction.USER_SESSION, user);
                            break;
                        }
                    }
                }
            }
        }
        return actionInvocation.invoke();
    }
}