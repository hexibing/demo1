package com.bingo.lucklybaby.service;

import com.bingo.lucklybaby.configDto.BaseDto;
import com.bingo.lucklybaby.model.Manager;

public interface IManagerService {

    BaseDto login(Manager manager);

    Manager getManager(Manager manager);

}
