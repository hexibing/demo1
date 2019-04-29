package com.example.demo1.service;

import com.example.demo1.dto.ManagerDto;
import com.example.demo1.model.Manager;

public interface IManagerService {

    Manager getMangerByManagerCode(String managerCode);


    ManagerDto  getManagerDtoById(Long id);


    void addManager(Manager manager);
}
