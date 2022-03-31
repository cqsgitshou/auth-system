//package com.zimo.auth.config.datasource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
//
///**
// * 资源服务器配置
// *
// * @author chenqs
// * @date 2022/3/7
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {
//	@Autowired
//	protected RemoteTokenServices remoteTokenServices;
//
//	@Override
//	public void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//				.authorizeRequests().antMatchers("/token/**", "/actuator/**", "/auth/skip/**").permitAll()
//				.anyRequest().authenticated().and().csrf().disable();
//	}
//
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
//
//		// 修改默认的用户认证信息
//		UserAuthenticationConverter userTokenConverter = new AuthUserAuthenticationConverter();
//		accessTokenConverter.setUserTokenConverter(userTokenConverter);
//
//		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
//		resources
//				// .tokenExtractor(new BearerTokenCheckConfig())
//				.tokenServices(remoteTokenServices);
//	}
//
//
//
//
//
//}
