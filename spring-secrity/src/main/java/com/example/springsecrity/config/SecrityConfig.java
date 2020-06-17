package com.example.springsecrity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * https://segmentfault.com/a/1190000020705382
 * Spring Security 实战干货：自定义配置类入口WebSecurityConfigurerAdapter
 * @author vanish
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecrityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 核心过滤器配置方法
     * void configure(WebSecurity web) 用来配置 WebSecurity 。
     * 而 WebSecurity 是基于 Servlet Filter 用来配置 springSecurityFilterChain 。
     * 而 springSecurityFilterChain 又被委托给了 Spring Security 核心过滤器 Bean DelegatingFilterProxy 。
     * 相关逻辑你可以在 WebSecurityConfiguration 中找到。我们一般不会过多来自定义 WebSecurity ,
     * 使用较多的使其ignoring() 方法用来忽略 Spring Security 对静态资源的控制。
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
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
        super.configure(http);
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
        PasswordEncoder bCryptPasswordEncoder = getPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(bCryptPasswordEncoder.encode("123456"))
                .roles("admin");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
