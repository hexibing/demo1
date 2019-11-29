package com.bingo.lucklybaby.controller;

import com.bingo.lucklybaby.ConfigDto.BaseDto;
import com.bingo.lucklybaby.model.Manager;
import com.bingo.lucklybaby.model.User;
import com.bingo.lucklybaby.service.IManagerService;
import com.bingo.lucklybaby.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private  static Logger logger= LoggerFactory.getLogger(ManagerController.class);


    @Autowired
    private IUserService userService;
    @Autowired
    private IManagerService managerService;


    @RequestMapping(value = "/login")
    public BaseDto login(@RequestBody Manager manager){
        return managerService.login(manager);
    }

    @RequestMapping(value = "/getInfo")
    public User getInfo(){

        logger.info("aaaa");
        return userService.getUserInfo(1L);
    }

    @RequestMapping(value = "/getManager")
    public Manager getManager(@RequestBody Manager manager){

        logger.info("getManager");
        return managerService.getManager(manager);
    }


}
