package com.mx.popcorn.service;

import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.District;
import com.mx.popcorn.domain.Province;

import java.util.List;

/**
 * Created by Administrator on 2014-10-30.
 */
public interface SpaceService extends BaseService {
    List getAllRegion();

    List getAllCity();

    City getCityById(Long id);

    List getAllProvince();

    Province getProvinceById(Long id);

    List getAllDistrict();

    District getDistrictById(Long id);

    void addCity(City city);

    List getAllCityByProvince(Province province);

    List getAllDistrictByCity(City city);

    void addProvince(Province province);

    void addDistrict(District district);

    City getCityByName(String spaceName);
}
