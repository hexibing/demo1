package com.bingo.lucklybaby.model;

import java.util.Date;

public class User {
    private Long id;

    private String username;

    private String password;

    private Date createdatetime;

    private Date updatedatetime;

    public User(Long id, String username, String password, Date createdatetime, Date updatedatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdatetime = createdatetime;
        this.updatedatetime = updatedatetime;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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