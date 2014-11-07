package com.mx.popcorn.domain;

import com.mx.popcorn.utils.WebUtils;
import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20)
    private String week;

    @Column(precision = 2)
    private float price;

    @ManyToOne
    @JoinColumn(name = "hallId")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "schedule")
    private Set<TicketOrder> ticketOrders;

    @Temporal(TemporalType.DATE)
    private Date showTime;

    @Column(length = 20)
    private String time;

    private Date createDate;

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", week='" + week + '\'' +
                ", price=" + price +
                ", hall=" + hall.getNumber() +
                ", movie=" + movie.getName() +
                ", showTime=" + showTime.toString() +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @JSON(serialize = false)
    public Set<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(Set<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
