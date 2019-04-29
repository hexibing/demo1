package com.example.demo1.shiro;

import com.example.demo1.dto.AdminUserTokenDto;
import com.example.demo1.util.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {


    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        AdminUserTokenDto tk = (AdminUserTokenDto) authcToken;
        //如果是免密登录直接返回true
        if(StringUtil.isNotNil(tk.getType())){
            return true;
        }

        //不是免密登录，调用父类的方法
        return super.doCredentialsMatch(tk, info);
    }

}
