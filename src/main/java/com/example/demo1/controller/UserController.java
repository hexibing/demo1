package com.example.demo1.controller;

import com.example.demo1.dto.UserDto;
import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private  static Logger logger=Logger.getLogger(UserController.class);





    @Autowired
    private IUserService userService;



    @RequestMapping(value = "/getInfo")
    public User getInfo(){

        logger.info("aaaa");
        return userService.getUserInfo("1");
    }

    @RequestMapping(value = "/getInfo1")
    public UserDto getInfo1(){

        logger.info("aaaa");
        return userService.getUserDto("1");
    }

    @RequestMapping(value = "/saveRedis")
    public void saveRedis(){
        logger.info("开启redis缓存");
        Jedis jedis=new Jedis("localhost");
        jedis.set("myname","hexibing");
    }


    @RequestMapping(value = "/getRedis")
    public String getRedis(){
        Jedis jedis=new Jedis("localhost");
        String s1=jedis.get("myname");
        System.out.println("1111"+s1);
        return   s1;
    }



    private List<UserDto> getUserDtoList() {
        UserDto userDto=userService.getUserDto("1");

        List<UserDto> list = new ArrayList<>();
        list.add(userDto);

        return list;
    }

}
