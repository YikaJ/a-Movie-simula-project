package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.City;
import com.mx.popcorn.domain.Province;
import com.mx.popcorn.domain.Space;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
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


    private Long provinceId;
    private Long cityId;

    @Action(value = "catchCity",
            results = {@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"})})
    public String catchCity(){
        try {
            if (provinceId == null)
                return null;
            Province province = spaceService.getProvinceById(provinceId);
            if (province == null)
                return null;
            jsonMap.put("data", spaceService.getAllCityByProvince(province));
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }

    @Action(value = "catchProvince",
            results = {@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"})})
    public String catchProvince(){
        try {
            jsonMap.put("data", provinceId == null
                    ? spaceService.getAllProvince()
                    : spaceService.getProvinceById(provinceId));
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }

    @Action(value = "catchDistrict",
            results = {@Result(name = SUCCESS, type = JSON, params = {"root", "jsonMap"})})
    public String catchDistrict(){
        try {
            if (cityId == null)
                return null;
            City city = spaceService.getCityById(cityId);
            if (city == null)
                return null;
            jsonMap.put("data", spaceService.getAllDistrictByCity(city));
            jsonMap.put(JSON_STATUS_HEADER, true);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            jsonMap.put(JSON_STATUS_HEADER, ERROR);
            return ERROR;
        }
    }



    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
