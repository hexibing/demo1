package com.example.demo1.exception;

import com.example.demo1.enums.IRespCode;
import com.example.demo1.enums.SystemRespCode;

/**
 * 服务层异常
 */
public class ServiceException extends  RuntimeException {

    private static final long serialVersionUID = 1530260006422925767L;

    private int code;

    private String msg;

    public ServiceException() {
        super();
    }

    public ServiceException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(IRespCode respCode){
        super();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ServiceException(String msg){
        super();
        this.code = SystemRespCode.SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public ServiceException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
