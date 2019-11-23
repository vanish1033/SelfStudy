package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:whr 2019/9/26
 */
@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String welcome() {
        return "forward:/welcome.jsp";
    }
}
