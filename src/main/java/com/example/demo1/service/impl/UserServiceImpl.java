package com.example.demo1.service.impl;

import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String user_id) {

        return userMapper.selectByPrimaryKey(user_id);
    }
}
