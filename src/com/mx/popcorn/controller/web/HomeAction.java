package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
public class HomeAction extends BaseAction{


    public String index(){
        return SUCCESS;
    }

}
