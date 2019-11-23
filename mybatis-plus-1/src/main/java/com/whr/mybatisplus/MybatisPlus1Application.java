package com.whr.mybatisplus;

import com.whr.mybatisplus.dao.StudentMapper;
import com.whr.mybatisplus.domain.TblStudent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.whr.mybatisplus.dao")
@SpringBootApplication
public class MybatisPlus1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisPlus1Application.class, args);
        StudentMapper bean = run.getBean(StudentMapper.class);
        TblStudent entity = new TblStudent();
        entity.setName("王富贵1");
        entity.setAge(12);
        entity.setEmail("123@qq.com");
        entity.setClassId(2);

        bean.insert(entity);
    }

}
