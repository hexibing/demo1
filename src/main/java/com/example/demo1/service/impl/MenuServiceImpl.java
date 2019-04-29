package com.example.demo1.service.impl;

import com.example.demo1.mapper.ManagerMapper;
import com.example.demo1.mapper.ManagerRoleMapper;
import com.example.demo1.mapper.MenuMapper;
import com.example.demo1.mapper.RoleMenuMapper;
import com.example.demo1.model.*;
import com.example.demo1.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private ManagerRoleMapper managerRoleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<String> getManagerMenuPermsList(long managerId) {
        List<String> menuList=new ArrayList<>();
        ManagerRoleExample managerRoleExample = new ManagerRoleExample();
        ManagerRoleExample.Criteria managerRoleCirteria = managerRoleExample.createCriteria();
        managerRoleCirteria.andManagerIdEqualTo(managerId);
        List<ManagerRole> managerRoleList = managerRoleMapper.selectByExample(managerRoleExample);
        if (managerRoleList.size() > 0) {
            ManagerRole managerRole = managerRoleList.get(0);
            RoleMenuExample roleMenuExample = new RoleMenuExample();
            RoleMenuExample.Criteria roleMenuCriteria = roleMenuExample.createCriteria();
            roleMenuCriteria.andRoleIdEqualTo(managerRole.getRoleId());
            List<RoleMenu> roleMenuList = roleMenuMapper.selectByExample(roleMenuExample);
            for (RoleMenu r:roleMenuList) {
                 Menu menu= menuMapper.selectByPrimaryKey(r.getMenuId());
                menuList.add(menu.getPerms());
            }
        }
        return menuList;
    }
}
