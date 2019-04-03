package com.example.demo1.controller;


import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import com.example.demo1.util.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    private MQSender mqSender;
    @Autowired
    private IUserService userService;

    @PostMapping("/hello")
    public void hello() {

        User user= userService.getUserInfo("1");

        mqSender.send(user);
    }


}
