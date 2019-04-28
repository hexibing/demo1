package com.example.demo1.service.impl;

import com.example.demo1.mapper.BatchMapper;
import com.example.demo1.mapper.CouponMapper;
import com.example.demo1.model.Batch;
import com.example.demo1.model.Coupon;
import com.example.demo1.model.CouponExample;
import com.example.demo1.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private BatchMapper batchMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public int getByCode(String code) {
        CouponExample example=new CouponExample();
        CouponExample.Criteria criteria=example.createCriteria();
        criteria.andCouponCodeEqualTo(code);

        return  couponMapper.selectByExample(example).size();
    }

    @Override
    public Batch getBatchById(int batch_id) {
        return batchMapper.selectByPrimaryKey(batch_id);
    }

    @Override
    public void insertCoupon(Coupon coupon) {
        couponMapper.insertSelective(coupon);
    }

}
