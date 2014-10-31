package com.mx.popcorn.controller.abstractAc;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Administrator on 2014-10-31.
 */
public abstract class UserAbstractAction extends ModelDrivenBaseAction<User> {


    public abstract void doAfterLogin();





}
