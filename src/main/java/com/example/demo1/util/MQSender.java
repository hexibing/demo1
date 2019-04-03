package com.example.demo1.util;

import com.alibaba.fastjson.JSONObject;
import com.example.demo1.config.RabbitConfig;
import com.example.demo1.controller.UserController;
import com.example.demo1.model.User;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MQSender {

    private  static Logger log=Logger.getLogger(UserController.class);
    @Autowired
    AmqpTemplate amqpTemplate;


    public void send(){
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.amqpTemplate.convertAndSend("helloQueue", sendMsg);
    }

    public void send(User user){
        String object=JSONObject.toJSONString(user);
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + object);
        this.amqpTemplate.convertAndSend("helloQueue", object);
    }

}
