package com.whr.testpagehelper.service.impl;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.whr.testpagehelper.domain.Emp;
import com.whr.testpagehelper.dao.EmpMapper;

import java.util.List;

@Service
public class EmpServiceImpl {

    @Resource
    private EmpMapper empMapper;

    
    public int deleteByPrimaryKey(Integer empno) {
        return empMapper.deleteByPrimaryKey(empno);
    }

    
    public int insert(Emp record) {
        return empMapper.insert(record);
    }

    
    public int insertSelective(Emp record) {
        return empMapper.insertSelective(record);
    }

    
    public Emp selectByPrimaryKey(Integer empno) {
        return empMapper.selectByPrimaryKey(empno);
    }

    
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }

    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

}
