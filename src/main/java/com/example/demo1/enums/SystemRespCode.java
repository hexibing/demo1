package com.example.demo1.enums;

public enum  SystemRespCode implements  IRespCode {
    SUCCESS(0,"成功"),
    SERVER_ERROR(500,"服务器内部错误"),
    AUTHORIZE_ERROR(600,"没有后台访问权限"),
    AUTHENTICATE_ERROR(600,"用户没有登录"),
    LOGIN_NAME_ERROR(600,"用户账号错误"),
    LOGIN_PASSWORD_ERROR(600,"用户密码错误"),
    PARAM_ERROR(400,"参数错误"),
    NOT_LOGIN(1000,"请登录后再访问"),
    LOGIN_ERR(1001,"登陆错误"),
            ;
    private int code;
    private String msg;

    SystemRespCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
