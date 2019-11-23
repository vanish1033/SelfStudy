package com.bjpowernode.service.impl;

import com.bjpowernode.dao.TblStudentDao;
import com.bjpowernode.domain.TblStudent;
import com.bjpowernode.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:whr 2019/9/26
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    TblStudentDao studentDao;

    @Override
    public int addStu(TblStudent student) {
        return studentDao.insert(student);
    }

    @Override
    public List<TblStudent> showAllStu() {
        return studentDao.selectAll();
    }
}
