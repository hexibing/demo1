package com.bingo.lucklybaby.service;

import com.bingo.lucklybaby.ConfigDto.BaseDto;
import com.bingo.lucklybaby.model.Manager;

public interface IManagerService {

    BaseDto login(Manager manager);
}
