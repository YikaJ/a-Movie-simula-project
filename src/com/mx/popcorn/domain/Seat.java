package com.mx.popcorn.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    private int col;

    private int row;

    private int status;

    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "hallId")
    private Hall hall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
