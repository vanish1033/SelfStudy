package com.whr.testpagehelper.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author:whr 2019/12/1
 */
@Configuration
@MapperScan("com.whr.testpagehelper.dao")
public class MybatisConfig {
}
