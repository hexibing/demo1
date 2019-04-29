package com.example.demo1.service.impl;

import com.example.demo1.mapper.ManagerRoleMapper;
import com.example.demo1.model.ManagerRole;
import com.example.demo1.model.ManagerRoleExample;
import com.example.demo1.service.IManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ManagerRoleServiceImpl implements IManagerRoleService {
    @Autowired
    private ManagerRoleMapper managerRoleMapper;

    @Override
    public List<Long> queryRoleIdList(long managerId) {
        List<Long> roles=new ArrayList<>();
        ManagerRoleExample example =new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria=example.createCriteria();
        criteria.andManagerIdEqualTo(managerId);
        List<ManagerRole> managerRoleList=managerRoleMapper.selectByExample(example);
        if (managerRoleList.size()>0){
            for ( ManagerRole role: managerRoleList) {
                roles.add(role.getRoleId());
            }
        }
        return roles;
    }
}
