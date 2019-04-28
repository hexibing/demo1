package com.example.demo1.mapper;

import com.example.demo1.model.Batch;
import com.example.demo1.model.BatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BatchMapper {
    int countByExample(BatchExample example);

    int deleteByExample(BatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Batch record);

    int insertSelective(Batch record);

    List<Batch> selectByExampleWithRowbounds(BatchExample example, RowBounds rowBounds);

    List<Batch> selectByExample(BatchExample example);

    Batch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByExample(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
}