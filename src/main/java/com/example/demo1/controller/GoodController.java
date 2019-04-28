package com.example.demo1.controller;


import com.example.demo1.ConfigDto.BaseDto;
import com.example.demo1.model.Good;
import com.example.demo1.service.IGoodService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
public class GoodController {
    private  static Logger log=Logger.getLogger(GoodController.class);

    @Autowired
    private IGoodService goodService;

    @PostMapping("/addGood")
    public BaseDto addGood(){
        log.info("开始添加");

        goodService.addGood(new Good());
      return  new BaseDto(true);
    }



}
