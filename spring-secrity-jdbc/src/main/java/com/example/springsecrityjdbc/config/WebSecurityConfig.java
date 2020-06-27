package com.example.springsecrityjdbc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * https://segmentfault.com/a/1190000020705382
 * Spring Security 实战干货：自定义配置类入口WebSecurityConfigurerAdapter
 * @author vanish
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * final -> 构造对象时必须赋值
     */
    final UserDetailsService userDetailsService;

    final PasswordEncoder passwordEncoder;

    /**
     * 构造函数注入
     *
     * @param userDetailsService
     */
    public WebSecurityConfig(@Qualifier("myJdbcUserDetailsService") UserDetailsService userDetailsService,
                             @Qualifier("pbkdf2PasswordEncoder") PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 认证管理器配置方法
     * void configure(AuthenticationManagerBuilder auth) 用来配置认证管理器AuthenticationManager。
     * 说白了就是所有 UserDetails 相关的它都管，包含 PasswordEncoder 密码机。
     * 如果你不清楚可以通过 Spring Security 中的 UserDetail 进行了解。
     * 本文对 AuthenticationManager 不做具体分析讲解，后面会有专门的文章来讲这个东西 。
     * 可通过 Spring Security 实战系列 进行学习。
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 安全过滤器链配置方法
     * void configure(HttpSecurity http) 这个是我们使用最多的，用来配置 HttpSecurity 。
     * HttpSecurity 用于构建一个安全过滤器链 SecurityFilterChain 。
     * SecurityFilterChain 最终被注入核心过滤器 。
     * HttpSecurity 有许多我们需要的配置。
     * 我们可以通过它来进行自定义安全访问策略。所以我们单独开一章来讲解这个东西。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.csrf().disable();
        //设置登录页，并且设置登录页不需要权限
        http.formLogin().loginPage("/login.html").permitAll()
                .and().formLogin().loginProcessingUrl("/login");

        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password").defaultSuccessUrl("/loginSuccess.html");

//        http.authorizeRequests()
//                .antMatchers("3423")
//                .hasRole("213421")
//                .antMatchers("213421")
//                .hasRole("213423");

    }
}
