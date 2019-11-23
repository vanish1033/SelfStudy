package com.bjpowernode.controller;

import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:whr 2019/9/24
 * <p>
 * The world is so beautiful, but I have never noticed
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/showAllUser")
    public ModelAndView show() {
        List<User> users = userService.selectAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", users);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

}

