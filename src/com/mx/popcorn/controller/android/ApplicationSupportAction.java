package com.mx.popcorn.controller.android;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Enumeration;

/**
 * Created by Administrator on 2014-10-22.
 */
@Controller
@Scope("prototype")
public class ApplicationSupportAction extends ActionSupport {

    private String name;
    private String password;

    public String appLogin(){
        System.out.println("-----name----------"+name+"-------------password-------"+password);
        Enumeration iteration = ServletActionContext.getRequest().getHeaderNames();
        while (iteration.hasMoreElements()){
            String head = (String) iteration.nextElement();
            System.out.println(head+" : "+ ServletActionContext.getRequest().getHeader(head));
        }
        try {
            if (name.trim().equals("韩都") && password.trim().equals("123"))
                return SUCCESS;
            else{
                return "login_error";
            }
        }catch (Exception e){
            e.printStackTrace();
            return  ERROR;

        }
    }




    /*===============================get/set===============================*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
