package com.bjpowernode.controller;

import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:whr 2019/9/25
 */
@Controller
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping("/{bookId}")
    public void test1(@PathVariable("bookId") String bookId) {
        System.out.println("bookId = " + bookId);
    }

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("key", 123);
        mv.setViewName("forward:/welcome.jsp");
        return mv;
    }

    @RequestMapping("/{bookId}/{var:[a-z]+}-{ver:\\d\\.\\d}")
    public void test3(@PathVariable("bookId") String bookId, @PathVariable("var") String var, @PathVariable("ver") String ver) {
        System.out.println("bookId = " + bookId);
        System.out.println("var = " + var);
        System.out.println("ver = " + ver);
    }

    @RequestMapping("/{bookId}/{isbn}")
    public void test2(@PathVariable("bookId") String bookId, @PathVariable("isbn") String isbn) {
        System.out.println("bookId =" + bookId);
        System.out.println("isbn = " + isbn);
        System.out.println("test2");
    }

    @RequestMapping("/{bookId}/java")
    public void test4() {
        System.out.println("java");
    }

    @RequestMapping("/{bookId}/*/java")
    public void test6(HttpServletRequest request) {
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("*通配符");
    }

    @RequestMapping("/{bookId}/?/java")
    public void test5(HttpServletRequest request) {
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("?通配符");
    }

    @PutMapping("/{bookId}/?/java")
    public void test7(HttpServletRequest request) {
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("put");
    }

    @DeleteMapping("/test8/delete")
    public void test8(HttpServletRequest request) {
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("delete");
    }

    @PostMapping(value = "/test9", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User test9(@RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }

    @RequestMapping("/test10")
    @ResponseBody
    public User test10(@RequestBody User user) {
        System.out.println("testJson:" + user);
        return user;
    }


}
