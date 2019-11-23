package com.example.demo.controller;

import com.example.demo.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @author:whr 2019/11/23
 */
@RestController
public class BaseController {

    @RequestMapping("/test1")
    public Object test1(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Methods", "GET,POST");
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setName("梁朝伟");
            student.setAge(12);
            students.add(student);
        }
        return students;
    }

    @RequestMapping("/test2")
    public Object test2() {
        return new Object();
    }

}
