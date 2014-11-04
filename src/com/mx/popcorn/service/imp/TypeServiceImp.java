package com.mx.popcorn.service.imp;

import com.mx.popcorn.service.BaseService;
import com.mx.popcorn.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2014-11-3.
 */
@Service
@Transactional
public class TypeServiceImp extends BaseServiceImp implements TypeService {
    @Override
    public List getAllMovieType() {
        return null;
    }

    @Override
    public List getAllMovieVersion() {
        return null;
    }
}
