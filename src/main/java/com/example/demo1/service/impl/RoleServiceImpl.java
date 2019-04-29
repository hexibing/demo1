package com.example.demo1.service.impl;

import com.example.demo1.mapper.RoleMapper;
import com.example.demo1.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public String getNameById(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId).getRoleName();
    }
}
