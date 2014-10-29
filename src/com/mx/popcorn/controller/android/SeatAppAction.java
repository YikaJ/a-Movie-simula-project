package com.mx.popcorn.controller.android;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Seat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
public class SeatAppAction extends ModelDrivenBaseAction<Seat> {
}
