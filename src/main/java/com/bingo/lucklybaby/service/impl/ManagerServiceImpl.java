package com.bingo.lucklybaby.service.impl;

import com.bingo.lucklybaby.ConfigDto.BaseDto;
import com.bingo.lucklybaby.mapper.ManagerMapper;
import com.bingo.lucklybaby.model.Manager;
import com.bingo.lucklybaby.model.ManagerExample;
import com.bingo.lucklybaby.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public BaseDto login(Manager manager) {
        ManagerExample example=new ManagerExample();
        ManagerExample.Criteria criteria=example.createCriteria();
        criteria.andNameEqualTo(manager.getName());
        criteria.andPasswordEqualTo(manager.getPassword());

        List<Manager> list =managerMapper.selectByExample(example);
        if (list.size() > 0 && list != null){
            return new BaseDto(true);
        }
        return new BaseDto(false);
    }

    @Override
    public Manager getManager(Manager manager) {
        ManagerExample example=new ManagerExample();
        ManagerExample.Criteria criteria=example.createCriteria();
        criteria.andNameEqualTo(manager.getName());
        criteria.andPasswordEqualTo(manager.getPassword());
        List<Manager> list =managerMapper.selectByExample(example);
        return list.get(0);
    }
}
