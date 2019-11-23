package com.bjpowernode.controller;

import com.bjpowernode.domain.TblStudent;
import com.bjpowernode.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:whr 2019/9/26
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    StuService stuService;

    //    @RequestMapping(value="abc",produces = {"application/json;charset=UTF-8"})
    @RequestMapping(value = "/add")
    @ResponseBody
    public String addStu(TblStudent student) {
        int flag = stuService.addStu(student);
        return flag == 1 ? "添加学生成功" : "添加学生失败";
    }

    @RequestMapping(value = "/showAllStu")
    @ResponseBody
    public List<TblStudent> showAllStu() {
        List<TblStudent> stuList = stuService.showAllStu();
        return stuList;
    }

}
