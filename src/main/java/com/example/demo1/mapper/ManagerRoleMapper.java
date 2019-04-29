package com.example.demo1.mapper;

import com.example.demo1.model.ManagerRole;
import com.example.demo1.model.ManagerRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ManagerRoleMapper {
    int countByExample(ManagerRoleExample example);

    int deleteByExample(ManagerRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerRole record);

    int insertSelective(ManagerRole record);

    List<ManagerRole> selectByExampleWithRowbounds(ManagerRoleExample example, RowBounds rowBounds);

    List<ManagerRole> selectByExample(ManagerRoleExample example);

    ManagerRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    int updateByExample(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    int updateByPrimaryKeySelective(ManagerRole record);

    int updateByPrimaryKey(ManagerRole record);
}