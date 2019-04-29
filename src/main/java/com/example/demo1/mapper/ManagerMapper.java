package com.example.demo1.mapper;

import com.example.demo1.model.Manager;
import com.example.demo1.model.ManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ManagerMapper {
    int countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExampleWithRowbounds(ManagerExample example, RowBounds rowBounds);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}