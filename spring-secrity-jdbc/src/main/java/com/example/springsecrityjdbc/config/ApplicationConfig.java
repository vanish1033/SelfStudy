package com.example.springsecrityjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author vanish
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name = "myJdbcUserDetailsService")
    public UserDetailsService getUserDetailsService() {
        PasswordEncoder passwordEncoder = getPasswordEncoder();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        if (!jdbcUserDetailsManager.userExists("wangHongRui")) {
            jdbcUserDetailsManager.createUser(new User("wangHongRui",
                    passwordEncoder.encode("123"),
                    Stream.of("ROLE_ADMIN").map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList())));
        }
        if (!jdbcUserDetailsManager.userExists("wangYue")) {
            jdbcUserDetailsManager.createUser(new User("wangYue",
                    passwordEncoder.encode("123"),
                    Stream.of("ROLE_ADMIN").map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList())));
        }
        if (!jdbcUserDetailsManager.userExists("miaoSen")) {
            jdbcUserDetailsManager.createUser(new User("miaoSen",
                    passwordEncoder.encode("123"),
                    Stream.of("ROLE_ADMIN").map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList())));
        }
        if (!jdbcUserDetailsManager.userExists("wangKuiXin")) {
            jdbcUserDetailsManager.createUser(new User("wangKuiXin",
                    passwordEncoder.encode("123"),
                    Stream.of("ROLE_ADMIN").map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList())));
        }
        return jdbcUserDetailsManager;
    }
}
