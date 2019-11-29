package com.bingo.lucklybaby.service.impl;

import com.bingo.lucklybaby.controller.UserController;
import com.bingo.lucklybaby.mapper.UserMapper;
import com.bingo.lucklybaby.model.User;
import com.bingo.lucklybaby.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService {
    private  static Logger log=Logger.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(Long user_id) {

        return userMapper.selectByPrimaryKey(user_id);
    }



}
