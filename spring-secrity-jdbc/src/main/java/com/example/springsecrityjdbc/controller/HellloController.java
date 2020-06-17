package com.example.springsecrityjdbc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 * @author vanish
 */
@RestController
public class HellloController {

    @RequestMapping("/hello")
    @PreAuthorize(value = "hasAnyRole('ADMIN','NORMAL')")
    public String hello() {
        return "Hello";
    }

}
