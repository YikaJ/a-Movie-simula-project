package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-29.
 */
@Controller
@Scope("prototype")
public class TypeAction  extends ModelDrivenBaseAction<Type> {
}
