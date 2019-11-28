package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:whr 2019/11/28
 */
@Controller
public class OneController {

    @RequestMapping("/")
    public String test1() {
        return "/test.html";
    }

}
