package com.mx.popcorn.service.imp;

import com.mx.popcorn.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2014-10-28.
 */
@Service
@Transactional
public class MovieServiceImp extends BaseServiceImp implements MovieService {
}
