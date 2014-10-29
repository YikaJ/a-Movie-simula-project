package com.mx.popcorn.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Administrator on 2014-10-29.
 */
@MappedSuperclass
public class Grade {

    @Id
    @GeneratedValue
    private Long id;

    @Column(precision = 1)
    private float levels;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLevels() {
        return levels;
    }

    public void setLevels(float levels) {
        this.levels = levels;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
