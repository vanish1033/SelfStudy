package com.bjpowernode.controller;

import com.bjpowernode.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:whr 2019/9/26
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/delClass")
    @ResponseBody
    public String delClass(Integer classId) {
        Integer flag = classService.delClassById(classId);
        return flag == 1 ? "删除成功" : "删除失败";
    }

}
