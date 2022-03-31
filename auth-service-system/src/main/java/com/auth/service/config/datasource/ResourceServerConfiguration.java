package com.auth.service.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器配置
 *
 * @author chenqs
 * @date 2022/3/7
 */
@Configuration
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(false);

	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests().antMatchers("/token/**","/admin/**", "/actuator/**", "/mobile/**").permitAll()
				.anyRequest().authenticated().and().csrf().disable();
	}
}
