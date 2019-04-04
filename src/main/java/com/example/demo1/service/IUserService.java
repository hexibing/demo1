package com.example.demo1.service;

import com.example.demo1.dto.UserDto;
import com.example.demo1.model.User;
import org.apache.ibatis.annotations.Mapper;


public interface IUserService {

    User getUserInfo(String user_id);

    UserDto getUserDto(String user_id);

    void updateUserInfo(User user);

    void addUser(User user);

    void deleteUser(String user_id);

    User getUserByExample(User user);

    void updateUser(User user);
}
