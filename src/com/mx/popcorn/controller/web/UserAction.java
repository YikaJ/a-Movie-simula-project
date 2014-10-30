package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@Namespace("/user")
public class UserAction  extends ModelDrivenBaseAction<User> {



    public String register(){
        try {
            System.out.println("----------email--"+model.getEmail()+"----------password--"+model.getPassword()+"--------------------------");
            userService.register(model);
            return SUCCESS;
        }catch (UserExitException e){
            e.printStackTrace();
            return "userExit";
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

}
