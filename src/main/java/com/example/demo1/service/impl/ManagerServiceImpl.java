package com.example.demo1.service.impl;

import com.example.demo1.dto.ManagerDto;
import com.example.demo1.mapper.ManagerMapper;
import com.example.demo1.mapper.ManagerRoleMapper;
import com.example.demo1.model.Manager;
import com.example.demo1.model.ManagerExample;
import com.example.demo1.service.IManagerRoleService;
import com.example.demo1.service.IManagerService;
import com.example.demo1.service.IRoleService;
import com.example.demo1.util.LocalDateTimeUtil;
import com.example.demo1.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerServiceImpl  implements IManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ManagerRoleMapper  managerRoleMapper;
    @Autowired
    private IManagerRoleService managerRoleService;
    @Autowired
    private IRoleService roleService;


    @Override
    public void addManager(Manager manager) {
        Manager addManager=new Manager();
        addManager.setManagerCode(manager.getManagerCode());
        if(StringUtil.isNil(manager.getSalt())){
            addManager.setSalt(StringUtil.generateLetters(20));
        }
        addManager.setManagerPassword(manager.getDBEncryptedPassword(manager.getManagerPassword(), addManager.getSalt()));
        addManager.setCreateDateTime(new Date());
        addManager.setUpdateDateTime(new Date());
        addManager.setDescription(manager.getDescription());
        managerMapper.insertSelective(addManager);
    }

    @Override
    public ManagerDto getManagerDtoById(Long id) {
        ManagerDto dto=new ManagerDto();
        Manager manager=managerMapper.selectByPrimaryKey(id);
        dto.setId(manager.getId());
        dto.setManagerCode(manager.getManagerCode());
        dto.setManagerName(manager.getManagerCode());
        dto.setCreateDateTime(LocalDateTimeUtil.DateToLocalDateTime(manager.getCreateDateTime()));
        dto.setDescription(manager.getDescription());

        dto.setRoleIdList(managerRoleService.queryRoleIdList(id));
//        dto.setMenuIdList(managerMapper.queryAllMenuId(id));
//        dto.setMenuUrlList(managerMapper.queryAllMenuUrl(id));
        if(dto.getRoleIdList().size() == 1 ){
            //只有一个角色
            Long rid = dto.getRoleIdList().get(0);
            dto.setRoleId(rid);
            dto.setRoleName(roleService.getNameById(rid));
        }
        return dto;
    }

    @Override
    public Manager getMangerByManagerCode(String managerCode) {
        ManagerExample example=new ManagerExample();
        ManagerExample.Criteria criteria=example.createCriteria();
        criteria.andManagerCodeEqualTo(managerCode);
        List<Manager> managerList=managerMapper.selectByExample(example);
        if (managerList.size()>0){
            return  managerList.get(0);
        }
        return null;
    }



}
