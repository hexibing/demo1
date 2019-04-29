package com.example.demo1.shiro;

import com.example.demo1.dto.AdminUserTokenDto;
import com.example.demo1.model.Manager;
import com.example.demo1.service.IManagerService;
import com.example.demo1.service.IMenuService;
import com.example.demo1.util.StringUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Jason_Ho
 * @create: 2018-11-08 18:31
 **/
public class ManagerRealm extends AuthorizingRealm {
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IManagerService managerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        Manager manager = (Manager)principals.getPrimaryPrincipal();
        Long managerId = manager.getId();

        List<String> permsList = menuService.getManagerMenuPermsList(managerId);

        Set<String> permsSet = new HashSet<String>();
        for(String perms : permsList){
            if(StringUtil.isNil(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        RetryLimitHashedCredentialsMatcher credentialsMatcher=new RetryLimitHashedCredentialsMatcher();
        setCredentialsMatcher(credentialsMatcher);

        AdminUserTokenDto token1 = (AdminUserTokenDto)token ;
        String managerCode = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        //查询用户信息
        Manager manager = managerService.getMangerByManagerCode(managerCode);

        if ("HASPWD".equals(token1.getType())){
            //账号不存在
            if(manager == null) {
                throw new UnknownAccountException("账号不正确");
            }
            if (password!=null){
                //密码错误
                String inputSha256 = manager.getDBEncryptedPassword(password, manager.getSalt());
                if(!inputSha256.equals(manager.getManagerPassword())) {
                    throw new IncorrectCredentialsException("密码不正确");
                }
            }
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(manager, password, getName());
        return info;
    }
}
