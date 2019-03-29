package com.example.demo1.controller;

import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello spring boot11111aaaaaa";
    }

    @RequestMapping(value = "/getInfo")
    public User getInfo(){
        return userService.getUserInfo("1");
    }


}
