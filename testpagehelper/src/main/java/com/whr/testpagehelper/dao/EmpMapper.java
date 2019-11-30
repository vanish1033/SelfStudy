package com.whr.testpagehelper.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.whr.testpagehelper.domain.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> selectAll();

}