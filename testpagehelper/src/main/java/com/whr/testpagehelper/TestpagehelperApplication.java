package com.whr.testpagehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.whr.testpagehelper.dao")
@SpringBootApplication
public class TestpagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestpagehelperApplication.class, args);
    }

}
