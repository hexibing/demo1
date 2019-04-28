package com.example.demo1.controller;


import com.example.demo1.ConfigDto.BaseDto;
import com.example.demo1.model.Coupon;
import com.example.demo1.service.ICouponService;
import com.example.demo1.util.CouponUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private ICouponService couponService;


    @PostMapping("/inserCounpon")
    public  BaseDto inserCounpon(){
        int count=0;
        for(;;){
            String code= CouponUtil.getCode();
            int size=couponService.getByCode(code);
            System.out.println(size+"长度");
            if (size<=0) {
                System.out.println(code);
                Coupon coupon=new Coupon();
                coupon.setCouponCode(code);
                coupon.setMoney(10f);
                coupon.setBatch_id(20190419);
                coupon.setCreate_time(new Date());
                couponService.insertCoupon(coupon);
                count++;
            }
            if (count==20){
                break;
            }
        }
        return  new BaseDto(true);
    }



}
