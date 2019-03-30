package com.example.demo1.dto;

import com.example.demo1.ConfigDto.BaseDto;
import lombok.Data;

@Data
public class UserDto extends BaseDto {

    private String user_id;

    private String userName;

    private Integer addressId;

    private String createTime;

    private String updateTime;



    public UserDto(boolean success){
        super(success);
    }





}
