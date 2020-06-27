package com.example.springsecrityjdbc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestController
 *
 * @author vanish
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize(value = "hasAnyRole('ADMIN','NORMAL')")
    public @ResponseBody
    String hello() {
        return "Hello";
    }

}
