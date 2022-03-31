package com.auth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author  chenqs
 * @desc Spring应用启动类
 * @date: 2022年2月25日
 */
// 成为客户端校验注释
@EnableResourceServer
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AuthServiceSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceSystemApplication.class, args);
    }
}
