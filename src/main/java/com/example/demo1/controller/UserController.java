package com.example.demo1.controller;

import com.example.demo1.ConfigDto.BaseDto;
import com.example.demo1.dto.UserDto;
import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    //增加
    @PostMapping(value = "/add")
    public BaseDto addUser(@RequestBody User user) {
        logger.info("addUser" + user.toString());
        userService.addUser(user);
        return new BaseDto(true);
    }

    //根据id查询
    @GetMapping(value = "/selectUserInfo/{user_id}")
    public UserDto getUserById(@PathVariable("user_id") String user_id) {
        logger.info("getUserById" + user_id);
        return userService.getUserDto(user_id);
    }

    //删除
    @PostMapping(value = "/deleteUserById/{user_id}")
    public BaseDto deleteUserById(@PathVariable("user_id") String user_id) {
        logger.info("deleteUserById" + user_id);
        userService.deleteUser(user_id);
        return new BaseDto(true);
    }

    //更新
    @PostMapping(value = "/updateUser")
    public BaseDto updateUser(@RequestBody User user) {
        logger.info("updateUser" + user.toString());
        userService.updateUser(user);
        return new BaseDto(true);
    }


    @GetMapping(value = "/getInfo")
    public User getInfo(@RequestBody User user) {
        logger.info("getInfo" + user.toString());
        return userService.getUserByExample(user);
    }

    @RequestMapping(value = "/saveRedis")
    public void saveRedis() {
        logger.info("开启redis缓存");
        Jedis jedis = new Jedis("localhost");
        jedis.set("myname", "hexibing");
    }


    @RequestMapping(value = "/getRedis")
    public String getRedis() {
        Jedis jedis = new Jedis("localhost");
        String s1 = jedis.get("myname");
        System.out.println("1111" + s1);
        return s1;
    }


    private List<UserDto> getUserDtoList() {
        UserDto userDto = userService.getUserDto("1");
        List<UserDto> list = new ArrayList<>();
        list.add(userDto);
        return list;
    }

}
