package com.bjpowernode.dao;

import com.bjpowernode.domain.TblClass;

public interface TblClassDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblClass record);

    int insertSelective(TblClass record);

    TblClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblClass record);

    int updateByPrimaryKey(TblClass record);

}