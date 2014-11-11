package com.mx.popcorn.service.imp;

import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.District;
import com.mx.popcorn.domain.Province;
import com.mx.popcorn.service.SpaceService;
import com.mx.popcorn.utils.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Override
    public List getAllCity() {
        QueryHelper helper = new QueryHelper(City.class, "c");
        return cityDao.find(helper, true);
    }

    @Override
    public City getCityById(Long id) {
        return cityDao.getById(id);
    }

    @Override
    public List getAllProvince() {
        QueryHelper helper = new QueryHelper(Province.class, "p");
        return provinceDao.find(helper, true);
    }

    @Override
    public Province getProvinceById(Long id) {
        return provinceDao.getById(id);
    }

    @Override
    public List getAllDistrict() {
        QueryHelper helper = new QueryHelper(District.class, "d");
        return districtDao.find(helper, true);
    }

    @Override
    public District getDistrictById(Long id) {
        return districtDao.getById(id);
    }

    @Override
    public void addCity(City city) {
        city.setCreateDate(new Date());
        cityDao.save(city);
    }

    @Override
    public List getAllCityByProvince(Province province) {
        QueryHelper helper = new QueryHelper(City.class, "c")
                .addWhereClause("provinceId", province.getId());
        return cityDao.find(helper, true);
    }

    @Override
    public List getAllDistrictByCity(City city) {
        if (city==null)
            return null;
        QueryHelper helper = new QueryHelper(District.class, "c")
                .addWhereClause("cityId", city.getId());
        return districtDao.find(helper, true);
    }

    @Override
    public void addProvince(Province province) {
        province.setCreateDate(new Date());
        provinceDao.save(province);
    }

    @Override
    public void addDistrict(District district) {
        district.setCreateDate(new Date());
        districtDao.save(district);
    }

    @Override
    public City getCityByName(String spaceName) {
        QueryHelper helper = new QueryHelper(District.class, "c")
                .addWhereClause("name", spaceName);
        return (City) cityDao.findUnique(helper, false);
    }
}
