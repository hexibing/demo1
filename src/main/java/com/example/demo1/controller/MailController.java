package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailController {

    @Autowired
    JavaMailSender jms;

    @GetMapping("/send")
    public String send(){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("mrhexibing@163.com");
        //接收者
        mainMessage.setTo("1057420022@qq.com");
        //发送的标题
        String url="<a>www.baidu.com</a>";
        mainMessage.setSubject("你的辣条好好吃哦！小老板");
        //发送的内容
        mainMessage.setText("批量购买辣条！请拨打17608416735！欢迎来电");
        jms.send(mainMessage);
        return "1";
    }





}
