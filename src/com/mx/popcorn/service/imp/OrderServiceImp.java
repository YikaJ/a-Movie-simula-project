package com.mx.popcorn.service.imp;

import com.mx.popcorn.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class OrderServiceImp extends BaseServiceImp implements OrderService {
}
