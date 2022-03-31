package com.auth.service.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 登录拦截
 */
@Configuration
public class WebConfigFilter implements WebMvcConfigurer {


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}