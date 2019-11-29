package com.bingo.lucklybaby.model;

import java.util.Date;

public class Manager {
    private Long id;

    private String name;

    private String password;

    private Date createdatetime;

    private Date updatedatetime;

    public Manager(Long id, String name, String password, Date createdatetime, Date updatedatetime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createdatetime = createdatetime;
        this.updatedatetime = updatedatetime;
    }

    public Manager() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(Date updatedatetime) {
        this.updatedatetime = updatedatetime;
    }
}