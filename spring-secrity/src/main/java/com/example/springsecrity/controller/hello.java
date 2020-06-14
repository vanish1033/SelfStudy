package com.example.springsecrity.controller;

import com.example.springsecrity.config.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @Autowired
    private Cat cat;

    @RequestMapping("/hello")
    @PreAuthorize(value = "hasAnyRole('admin','user')")
    public String hello() {
        return cat.getName();
    }
}
