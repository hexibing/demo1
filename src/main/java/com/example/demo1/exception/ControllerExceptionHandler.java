package com.example.demo1.exception;

import com.example.demo1.controller.ManagerController;
import com.example.demo1.enums.SystemRespCode;
import com.example.demo1.response.SystemResp;
import org.apache.commons.codec.Charsets;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final int RESPONSE_STATUS = 200;

    private static Logger log= Logger.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    public String handleException(HttpServletRequest request, HttpServletResponse response, ServiceException e) throws Exception {
        response.getOutputStream().write(e.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }

    @ExceptionHandler(value = {Exception.class})
    public String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        SystemResp resp = new SystemResp(SystemRespCode.SERVER_ERROR);
        response.getOutputStream().write(resp.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }


    @ExceptionHandler(value = {UnauthorizedException.class})
    public String handleException(HttpServletRequest request, HttpServletResponse response, UnauthorizedException e) throws Exception {
        log.info("异常处理***********用户没有接口访问权限");
        e.printStackTrace();
        SystemResp resp = new SystemResp(SystemRespCode.AUTHORIZE_ERROR);
        response.getOutputStream().write(resp.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }

    @ExceptionHandler(value = {UnauthenticatedException.class})
    public String handleException(HttpServletRequest request, HttpServletResponse response, UnauthenticatedException e) throws Exception {
        log.info("异常处理***********用户没有登录");
        e.printStackTrace();
        SystemResp resp = new SystemResp(SystemRespCode.AUTHENTICATE_ERROR);
        response.getOutputStream().write(resp.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }

    @ExceptionHandler(value = {UnknownAccountException.class})
    public String handleException(HttpServletRequest request, HttpServletResponse response, UnknownAccountException e) throws Exception {
        log.info("异常处理***********用户登录账号错误");
        e.printStackTrace();
        SystemResp resp = new SystemResp(SystemRespCode.LOGIN_NAME_ERROR);
        response.getOutputStream().write(resp.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }

    @ExceptionHandler(value = {IncorrectCredentialsException.class})
    public String handleException(HttpServletRequest request, HttpServletResponse response, IncorrectCredentialsException e) throws Exception {
        log.info("异常处理***********用户登录密码错误");
        e.printStackTrace();
        SystemResp resp = new SystemResp(SystemRespCode.LOGIN_PASSWORD_ERROR);
        response.getOutputStream().write(resp.toString().getBytes(Charsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(RESPONSE_STATUS);
        response.getOutputStream().flush();
        return null;
    }


}
