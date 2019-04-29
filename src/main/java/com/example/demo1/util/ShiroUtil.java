package com.example.demo1.util;

import com.example.demo1.model.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * shiro工具类
 */
public class ShiroUtil {
    //获取安全框架中session
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Manager getManagerDomain() {
        return (Manager) SecurityUtils.getSubject().getPrincipal();
    }
    //获取managerId
    public static Long getManagerId() {
        return getManagerDomain().getId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }
    //登录
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }
    //退出
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }


}
