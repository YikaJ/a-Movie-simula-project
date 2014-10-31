package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Space;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-29.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/space")
public class SpaceAction  extends ModelDrivenBaseAction<Space> {
}
