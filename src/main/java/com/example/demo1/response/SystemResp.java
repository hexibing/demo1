package com.example.demo1.response;

import com.example.demo1.enums.SystemRespCode;

/**
 * 系统响应
 *
 * @author hexibing
 * @create 2018-08-11 20:27
 **/
public class SystemResp {

    private int code;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SystemResp(SystemRespCode systemRespCode) {
        this.code = systemRespCode.getCode();
        this.msg = systemRespCode.getMsg();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("\"code\":").append(code);
        sb.append(", \"message\":\"").append(msg).append("\"");
        sb.append("}");
        return sb.toString();
    }

}
