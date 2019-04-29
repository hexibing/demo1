package com.example.demo1.dto;

import com.example.demo1.util.LocalDateTimeJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ManagerDto {

    private static final long serialVersionUID = -8350342123045969496L;

    @JsonSerialize(using = LocalDateTimeJsonSerializer.class) //application/json
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //application/x-www-form-urlencoded
    private LocalDateTime createDateTime;

    @JsonSerialize(using = LocalDateTimeJsonSerializer.class) //application/json
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //application/x-www-form-urlencoded
    private LocalDateTime updateDateTime;
    private Long id; //
    private String managerCode;
    private String  managerName; // 省ID
    private String  description; //
    private Integer provinceId;
    private String provinceName;
    private Integer cityId;
    private String cityName;
    private Integer districtId;
    private String districtName;
    private Integer streetId;
    private String streetName;
    private Integer regionId;
    private String longitude; // 经度
    private String latitude; // 纬度
    private Long managerId;
    private String managerPassword;
    private List<Long> roleIdList; //角色id列表
    private List<Long> menuIdList; //菜单id列表
    private List<String> menuUrlList; // 菜单url列表

    private Long roleId;
    private String roleName;

    private String  company;

}
