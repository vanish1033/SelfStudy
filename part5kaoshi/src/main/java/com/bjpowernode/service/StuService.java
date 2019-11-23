package com.bjpowernode.service;

import com.bjpowernode.domain.TblStudent;

import java.util.List;

/**
 * @author:whr 2019/9/26
 */
public interface StuService {

    int addStu(TblStudent student);

    List<TblStudent> showAllStu();
}
