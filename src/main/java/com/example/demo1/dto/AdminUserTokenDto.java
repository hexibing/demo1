package com.example.demo1.dto;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 实现UsernamePasswordToken并增加新方法，用于重写免密和有密
 */
@Data
public class AdminUserTokenDto extends UsernamePasswordToken {

    private static final long serialVersionUID = -2564928913725078138L;
    //标识，是否免密登录
    private String type;
    /**
     * 免密登录
     */
    public AdminUserTokenDto(String username) {
        super(username, "", false, null);
        this.type = "NOPWD";
    }

    /**
     * 账号密码登录
     */
    public AdminUserTokenDto(String username, String password) {
        super(username, password, false, null);
        this.type = "HASPWD";
    }
}
