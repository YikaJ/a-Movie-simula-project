package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.controller.abstractAc.UserAbstractAction;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/user")
public class UserAction  extends ModelDrivenBaseAction<User> {


    private boolean autoLogin = true;
    private String window_registerPwdAgain;

    /**
     * 注册
     * @return
     */
    @Action(value = "register",
            results={@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"}),
                    @Result(name = FAILURE, type = JSON, params = {"root", "jsonMap"}),
                    @Result(name = ERROR, type = JSON, params = {"root", "jsonMap"})})
    public String register(){
        try {
            System.out.println("----------email--" + model.getEmail() + "----------password--" + model.getPassword() + "--------------------------");
            if (!userService.isEmptyOfNick(model.getNick()))
                errorMap.put("nick", "该昵称已经被使用");
            if (!userService.isEmptyOfEmail(model.getEmail()))
                errorMap.put("email", "该邮箱已经注册过了");
            if (errorMap.size()>0){
                jsonMap.put(JSON_STATUS_HEADER, false);
                jsonMap.put("msg", errorMap);
                return FAILURE;
            }
            userService.register(model);
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }


    @Action(value = "login",
            results={@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"}),
                    @Result(name = FAILURE, type = JSON, params = {"root", "jsonMap"}),
                    @Result(name = ERROR, type = JSON, params = {"root", "jsonMap"})})
    public String login(){
        try{
            User user = userService.login(model.getEmail(), model.getPassword());
            if (user == null){
                msgMap.put("text", "账号或者密码错误");
                jsonMap.put("msg", msgMap);
                jsonMap.put(JSON_STATUS_HEADER, false);
                return FAILURE;
            }
            getSession().setAttribute(USER_SESSION, user);
            if (autoLogin){
                Cookie cookie = new Cookie("autoLogin", new BASE64Encoder().encode(model.getEmail().getBytes())+"_"+
                        new BASE64Encoder().encode(model.getPassword().getBytes()));
                cookie.setMaxAge(7*24*60*60);
                cookie.setPath("/");
                getResponse().addCookie(cookie);
            }
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }


    public boolean isAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    public String getWindow_registerPwdAgain() {
        return window_registerPwdAgain;
    }

    public void setWindow_registerPwdAgain(String window_registerPwdAgain) {
        this.window_registerPwdAgain = window_registerPwdAgain;
    }
}
