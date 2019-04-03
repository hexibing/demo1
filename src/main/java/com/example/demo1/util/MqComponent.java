package com.example.demo1.util;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * mq组件
 *
 * @author: mousycoder
 * @date: 2019-03-11 20:27
 * @version 1.0
 */
@Component
public class MqComponent {

    private static final Logger _log = Logger.getLogger(MqComponent.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(String msg) {
        _log.info("==========发送MQ消息==========:msg={}"+msg);
        this.amqpTemplate.convertAndSend("hello", msg);
    }

}
