package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.MovieNew;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@Namespace("/movieNew")
public class MovieNewAction  extends ModelDrivenBaseAction<MovieNew> {
}
