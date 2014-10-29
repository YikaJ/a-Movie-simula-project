package com.mx.popcorn.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class City extends Space {

    @ManyToOne
    @JoinColumn(name = "provinceId")
    private Province province;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "city")
    private Set<District> districts;

    @JSON(serialize = false)
    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
