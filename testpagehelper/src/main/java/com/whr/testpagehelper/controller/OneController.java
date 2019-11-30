package com.whr.testpagehelper.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whr.testpagehelper.domain.Emp;
import com.whr.testpagehelper.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:whr 2019/11/30
 */
@Slf4j
@RestController
public class OneController {

    @Autowired
    private EmpServiceImpl empService;

    @RequestMapping("/test/{pageNum}/{pageSize}")
    public PageInfo test(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> emps = empService.selectAll();
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps);
        log.info(JSON.toJSONString(empPageInfo));
        return empPageInfo;
    }

}
