package com.example.demo1.service.impl;

import com.example.demo1.common.DateUtil;
import com.example.demo1.controller.UserController;
import com.example.demo1.dto.UserDto;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.User;
import com.example.demo1.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService {
    private  static Logger log=Logger.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String user_id) {

        return userMapper.selectByPrimaryKey(user_id);
    }


    @Override
    public UserDto getUserDto(String user_id) {

        User user= userMapper.selectByPrimaryKey(user_id);
        UserDto dto=new UserDto(true);
        dto.setUser_id(user.getId());
        dto.setUserName(user.getUserName());
        dto.setAddressId(user.getAddressId());
        System.out.println(user.getCreateTime());
        log.info(user.getCreateTime());
        dto.setCreateTime(DateUtil.dateToFormatString(user.getCreateTime(),"yyyy-MM-dd HH:mm:dd"));
        dto.setUpdateTime(DateUtil.dateToFormatString(user.getUpdateTime(),"yyyy-MM-dd HH:mm:dd"));
        return dto;
    }
}
