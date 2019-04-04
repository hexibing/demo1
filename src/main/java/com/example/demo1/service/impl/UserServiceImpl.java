package com.example.demo1.service.impl;

import com.example.demo1.common.DateUtil;
import com.example.demo1.controller.UserController;
import com.example.demo1.dto.UserDto;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.model.User;
import com.example.demo1.model.UserExample;
import com.example.demo1.service.IUserService;
import com.example.demo1.util.IdUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService {
    private  static Logger log=Logger.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByExample(User user) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUser_nameEqualTo(user.getUser_name());
        User user1=userMapper.selectByExample(example).get(0);
        return user1;
    }

    @Override
    public void deleteUser(String user_id) {
        userMapper.deleteByPrimaryKey(user_id);
    }

    @Override
    public void addUser(User user) {
        try {
            String user_id=String.valueOf(IdUtil.getInstance().nextId());
            user.setId(user_id);
        }catch (Exception e){
            log.info("生成id异常");
        }

        userMapper.insertSelective(user);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserInfo(String user_id) {

        return userMapper.selectByPrimaryKey(user_id);
    }


    @Override
    public UserDto getUserDto(String user_id) {

        User user= userMapper.selectByPrimaryKey(user_id);
        UserDto dto=new UserDto(true);
        dto.setUser_id(user.getId());
        dto.setUserName(user.getUser_name());
        dto.setAddressId(user.getAddress_id());
        dto.setCreateTime(DateUtil.dateToFormatString(user.getCreate_time(),"yyyy-MM-dd HH:mm:dd"));
        dto.setUpdateTime(DateUtil.dateToFormatString(user.getUpdate_time(),"yyyy-MM-dd HH:mm:dd"));
        return dto;
    }
}
