package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.utils.TextTools;
import org.apache.struts2.ServletActionContext;
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



    private boolean autoLoginTo = false;
    private String window_registerPwdAgain;
    private Long provinceId;
    private Long cityId;
    private Long districtId;



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
            User user = userService.register(model);
            getSession().setAttribute(USER_SESSION, user);
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }


    /**
     * 用户登陆
     * @return
     */
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
            if (autoLoginTo){
                Cookie cookie = new Cookie("autoLoginTo", new BASE64Encoder().encode(model.getEmail().getBytes())+"_"+
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

    /**
     * 用于注册时异步效验邮箱和昵称是否已经被注册过
     * @return
     */
    @Action(value = "asyncValidate",
            results={@Result(name = SUCCESS, type = JSON, params = {"root", "true"}),
                    @Result(name = FAILURE, type = JSON, params = {"root", "false"})})
    public String asyncVal(){
        try{
            System.out.println("----------email--" + model.getEmail() + "----------password--" + model.getNick() + "--------------------------");
            return !TextTools.isEmpty(model.getEmail())
                            ? userService.isEmptyOfEmail(model.getEmail()) ? SUCCESS : FAILURE
                            :  !TextTools.isEmpty(model.getNick())
                                ?  userService.isEmptyOfNick(model.getNick()) ? SUCCESS : FAILURE
                                :   FAILURE;
        }catch (Exception e){
            e.printStackTrace();
            return FAILURE;
        }
    }

    /**
     * 注销
     * @return
     */
    @Action(value = "loginOff", results = {@Result(name = SUCCESS, type = "redirect", location = "${previous}")})
    public String loginOff(){
        Cookie cookies[] = ServletActionContext.getRequest().getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("autoLoginTo")){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                getResponse().addCookie(cookie);
            }
        }
        getSession().removeAttribute(USER_SESSION);
        getRequest().removeAttribute(USER_SESSION);
        previous = getRequest().getHeader(REFERER_SESSION);
        return SUCCESS;
    }

    @Action(value = "userImg",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/user/info/userImg.jsp")},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String userImg(){
        try{
            /*
            *
            * */
            getActionContext().put("user", userService.getUserById(getCurrentUser().getId()));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "updatePicture",
            results = {@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"})},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String updatePicture(){
        try{
            userService.updatePicture(model.getPicture(), getCurrentUser());
            jsonMap.put("msg", model.getPicture());
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 用户资料
     * @return
     */
    @Action(value = "userInfo",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/user/info/userInfo.jsp")},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String userInfo(){
        try{
            getActionContext().put("user", userService.getUserById(getCurrentUser().getId()));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 更改密码的页面
     * @return
     */
    @Action(value = "changePasswordUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/user/info/changePasswordUI.jsp")},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String changePasswordUI(){
        try{
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "changePassword",
            results = {@Result(name = SUCCESS, type = REDIRECT_ACTION, params = {"actionName", "changePasswordUI"})},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String changePassword(){
        try{
            if (!model.getPassword().trim().equals(getCurrentUser().getPassword())){
                addFieldError("password", "密码不正确");
                return INPUT;
            }
            userService.updatePassword(model);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "updateUserInfo",
            results = {@Result(name = SUCCESS, type = REDIRECT_ACTION, params = {"actionName", "userInfo"})},
            interceptorRefs = {@InterceptorRef("userPrivilegeInterceptorStack")})
    public String updateUserInfo(){
        try{
            if (provinceId != null || cityId != null || districtId != null){
                model.setDistrict(spaceService.getDistrictById(districtId));
            }
            userService.updateUserInfo(model);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }



    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public boolean isAutoLoginTo() {
        return autoLoginTo;
    }

    public void setAutoLoginTo(boolean autoLoginTo) {
        this.autoLoginTo = autoLoginTo;
    }

    public String getWindow_registerPwdAgain() {
        return window_registerPwdAgain;
    }

    public void setWindow_registerPwdAgain(String window_registerPwdAgain) {
        this.window_registerPwdAgain = window_registerPwdAgain;
    }
}
