package com.bingo.lucklybaby.service;

import com.bingo.lucklybaby.ConfigDto.BaseDto;
import com.bingo.lucklybaby.model.Manager;
import com.bingo.lucklybaby.model.User;

public interface IManagerService {

    BaseDto login(Manager manager);

    Manager getManager(Manager manager);

}
