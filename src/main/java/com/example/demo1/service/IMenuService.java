package com.example.demo1.service;

import com.example.demo1.model.Manager;

import java.util.List;

public interface IMenuService {
    List<String> getManagerMenuPermsList(long managerId);


}
