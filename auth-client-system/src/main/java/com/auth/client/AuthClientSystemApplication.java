package com.auth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author  chenqs
 * @desc Spring应用启动类
 * @date: 2022年2月25日
 */
@EnableResourceServer
@SpringBootApplication
public class AuthClientSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthClientSystemApplication.class, args);
    }
}
