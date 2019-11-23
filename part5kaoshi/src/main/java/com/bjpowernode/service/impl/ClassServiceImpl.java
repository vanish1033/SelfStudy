package com.bjpowernode.service.impl;

import com.bjpowernode.dao.TblClassDao;
import com.bjpowernode.dao.TblStudentDao;
import com.bjpowernode.domain.TblStudent;
import com.bjpowernode.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:whr 2019/9/26
 */
@Service
public class ClassServiceImpl implements ClassService {


    @Autowired
    TblClassDao classDao;

    @Autowired
    TblStudentDao studentDao;

    @Override
    @Transactional
    public Integer delClassById(Integer classId) {
        Integer flag = 0;

        List<TblStudent> tblStudents = studentDao.selectByClassId(classId);
        if (tblStudents.size() == studentDao.deleteByClassId(classId)) {
            flag = classDao.deleteByPrimaryKey(classId);
        } else {
            throw new RuntimeException();
        }
        return flag;
    }

}
