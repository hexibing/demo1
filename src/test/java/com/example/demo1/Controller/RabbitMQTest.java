package com.example.demo1.Controller;

import com.example.demo1.controller.UserController;
import com.example.demo1.service.IUserService;
import com.example.demo1.util.MQSender;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class RabbitMQTest {
    private  static Logger log=Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    static AmqpTemplate  amqpTemplate;


    public static void main(String[] args) {
        // 连接本地的 Redis 服务
//        log.info("开启mq");
//        String context="12321";
//        //amqpTemplate.convertAndSend("hello", context);
//        mqSender.send("aaaa");
//        log.info("mq已发送");
    }



}
