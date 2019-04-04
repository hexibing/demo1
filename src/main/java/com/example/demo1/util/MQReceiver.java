package com.example.demo1.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo1.controller.UserController;
import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "helloQueue")
public class MQReceiver {
    private  static Logger log=Logger.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RabbitHandler
    public void process(String user_str){
        log.info("接收mq消息"+user_str);
        JSONObject object= JSON.parseObject(user_str);
        log.info(object.toString());
        String user_id = object.getString("id");
        log.info("user_id="+user_id);
        User user=userService.getUserInfo(user_id);
        user.setUser_name("何玺斌");
        user.setUpdate_time(new Date());
        userService.updateUserInfo(user);
        log.info("update_success"+user.toString());
        System.out.println("Receiver1:"+user_str);
    }

}
