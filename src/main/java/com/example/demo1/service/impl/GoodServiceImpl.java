package com.example.demo1.service.impl;

import com.example.demo1.mapper.GoodMapper;
import com.example.demo1.model.Good;
import com.example.demo1.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class GoodServiceImpl  implements IGoodService {

    @Autowired
    private GoodMapper goodMapper;


    @Override
    public int addGood(Good good) {
        for (int i = 0; i < 60; i++) {
            Good good1=new Good();
            int temp=i;
            good1.setGood_name("商品"+temp++);
            good1.setPrice(BigDecimal.valueOf(temp++));
            good1.setCreate_time(new Date());
             goodMapper.insertSelective(good1);
        }
        return 1;
    }
}
