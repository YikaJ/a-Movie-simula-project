package com.mx.popcorn.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 会员权限拦截
 * Created by Administrator on 14-9-4.
 */
public class UserPrivilegeInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("-------------------userInterceptor-----------------------------");
        if (ServletActionContext.getRequest().getSession().getAttribute("user") ==null)
            return "login";
        return invocation.invoke();
    }
}
