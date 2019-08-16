package com.hx.provideruser.model;

import java.util.Date;

public class User {

    private Integer id;
    private Date date;

    public User() {

    }
    public User(Integer id) {
        this.id = id;
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
