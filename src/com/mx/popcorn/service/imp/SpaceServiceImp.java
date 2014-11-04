package com.mx.popcorn.service.imp;

import com.mx.popcorn.service.SpaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2014-10-30.
 */
@Service
@Transactional
public class SpaceServiceImp extends BaseServiceImp implements SpaceService {
    @Override
    public List getAllRegion() {
        return null;
    }
}
