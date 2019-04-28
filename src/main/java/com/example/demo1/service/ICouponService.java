package com.example.demo1.service;

import com.example.demo1.model.Batch;
import com.example.demo1.model.Coupon;

public interface ICouponService {

    Batch getBatchById(int batch_id);

    void insertCoupon(Coupon coupon);

    int getByCode(String code);

}
