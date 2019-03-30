package com.example.demo1.service;

import com.example.demo1.dto.UserDto;
import com.example.demo1.model.User;
import org.apache.ibatis.annotations.Mapper;


public interface IUserService {

    public User getUserInfo(String user_id);

    public UserDto getUserDto(String user_id);
}
