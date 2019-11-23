package com.bjpowernode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjpowernode.domain.TblStudent;

public interface TblStudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblStudent record);

    int insertSelective(TblStudent record);

    TblStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblStudent record);

    int updateByPrimaryKey(TblStudent record);

    int deleteByClassId(@Param("classId") Integer classId);

    List<TblStudent> selectByClassId(@Param("classId") Integer classId);

    List<TblStudent> selectAll();

}