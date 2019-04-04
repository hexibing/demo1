package com.example.demo1.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger logger = Logger.getLogger(ScheduledTask.class);
    private  static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    JavaMailSender jms;


    @Scheduled(fixedRate = 3000)
    public void reportCurrent() {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("mrhexibing@163.com");
        //接收者
        mainMessage.setTo("591465705@qq.com");
        //发送的标题
//        String title=" 你的辣条好好吃哦！小老板";
        String title="免费介绍对象";
        //发送的内容
//        String msg="批量购买辣条！请拨打17608416735！欢迎来电 ";
        String msg="请拨打17608416735！欢迎来电，谢谢合作。么么哒！ ";
        mainMessage.setSubject(title);
        mainMessage.setText(msg);
        jms.send(mainMessage);
        logger.info("现在时间：{}"+sdf.format(new Date()));
    }



}
