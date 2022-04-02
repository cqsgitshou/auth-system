package com.auth.client.config.datasource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 资源服务器配置
 *
 * @author chenqs
 * @date 2022/3/7
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class JWTResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler myExtendAccessDeniedHandler;

	@Autowired
	private  MyOAuth2AuthenticationEntryPoint myOAuth2AuthenticationEntryPoint;
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests().antMatchers("/token/**", "/actuator/**", "/auth/skip/**").permitAll()
				.anyRequest().authenticated().and().csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {

		resources
				// .tokenExtractor(new BearerTokenCheckConfig())
				.tokenServices(tokenServices())
				// 认证失败异常处理
				.authenticationEntryPoint(myOAuth2AuthenticationEntryPoint)
				// 权限异常处理
		        .accessDeniedHandler(myExtendAccessDeniedHandler);


	}
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());


		return defaultTokenServices;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("zimoyuncloud");


		DefaultAccessTokenConverter tokenConverter = (DefaultAccessTokenConverter)converter.getAccessTokenConverter();
		tokenConverter.setUserTokenConverter(new AuthUserAuthenticationConverter());

		return converter;
	}


}
