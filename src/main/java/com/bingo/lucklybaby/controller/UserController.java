package com.bingo.lucklybaby.controller;

import com.bingo.lucklybaby.model.User;
import com.bingo.lucklybaby.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private  static Logger logger=Logger.getLogger(UserController.class);


    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello spring boot11111";
    }

    @RequestMapping(value = "/getInfo")
    public User getInfo(){

        logger.info("aaaa");
        return userService.getUserInfo(1L);
    }



}
