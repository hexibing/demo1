package com.example.demo1.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionUtil {

    public void setManagerId(HttpServletRequest request, Long managerId){
        request.getSession().setAttribute("managerId", managerId);
    }

    public Long getManagerId(HttpServletRequest request) {
        if(request == null || request.getSession() == null) {
            return null;
        }
        return getManagerId(request.getSession());
    }

    public Long getManagerId(HttpSession session) {
        return (Long)session.getAttribute("managerId");
    }

    public void setWorkerId(HttpServletRequest request, Long workerId){
        request.getSession().setAttribute("workerId", workerId);
    }

    public Long getWorkerId(HttpServletRequest request) {
        if(request == null || request.getSession() == null) {
            return null;
        }
        return getWorkerId(request.getSession());
    }

    public Long getWorkerId(HttpSession session) {
        return (Long)session.getAttribute("workerId");
    }



    public void setCashierId(HttpServletRequest request, Long cashierId){
        request.getSession().setAttribute("cashierId", cashierId);
    }

    public Long getCashierId(HttpServletRequest request) {
        if(request == null || request.getSession() == null) {
            return null;
        }
        return getCashierId(request.getSession());
    }

    public Long getCashierId(HttpSession session) {
        return (Long)session.getAttribute("cashierId");
    }

    public Long getUserId(HttpSession session) {
        return (Long)session.getAttribute("userId");
    }

    public Long getUserId(HttpServletRequest request) {
        if(request == null || request.getSession() == null) {
            return null;
        }
        return getUserId(request.getSession());
    }

    public void setUserId(HttpServletRequest request, Long userId){
        request.getSession().setAttribute("userId", userId);
    }

    public void setSessionKey(HttpServletRequest request, String session_key){
        request.getSession().setAttribute("session_key", session_key);
    }

    public String getSessionKey(HttpServletRequest request) {
        if(request == null || request.getSession() == null) {
            return null;
        }
        return getSessionKey(request.getSession());
    }

    public String getSessionKey(HttpSession session) {
        return (String) session.getAttribute("session_key");
    }

}

