package com.auth.service.config.datasource;

import com.auth.service.web.dict.AuthConstants;
import com.auth.service.web.handler.FormAuthenticationFailureHandler;
import com.auth.service.web.handler.MD5PasswordEncoder;
import com.auth.service.web.handler.SsoLogoutSuccessHandler;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * 所在服务器的web配置
 * @author chenqs
 * @date: 202203
 */
@Primary
@Order(90)
@Configuration
public class WebSecurityConfigurer  extends WebSecurityConfigurerAdapter {

	/**
	 *.loginPage() //登陆界面
	 * .loginProcessingUrl()//登陆访问路径：提交表单之后跳转的地址,可以看作一个中转站，这个步骤就是验证user的一个过程
	 *  defaultSuccessUrl 登陆成功之后跳转的路径
	 * .antMatchers().permitAll() //匹配的路径不需要认证
	 * @param http
	 */
	@Override
	@SneakyThrows
	protected void configure(HttpSecurity http) {
		http.formLogin()
				.loginPage("/admin/login")
				// login表单跳转action
			     .loginProcessingUrl("/admin/form")
				.defaultSuccessUrl("/admin/success")
				.failureHandler(authenticationFailureHandler())
				.and()
				.authorizeRequests()
				.antMatchers(

						"/actuator/**","/admin/**").permitAll()
				.anyRequest().authenticated()
				.and().csrf().disable();

	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new FormAuthenticationFailureHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new SsoLogoutSuccessHandler();
	}

	@Resource
	private UserDetailsService userDetailsService;
	@Override
	@SneakyThrows
	public void configure(AuthenticationManagerBuilder auth) {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**");
	}

	/**
	 * PasswordEncoder接口用于执行密码的单向转换，以便安全地存储密码
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {

		String idForEncode = AuthConstants.MD5;
		Map encoders = new HashMap<>();

		encoders.put(idForEncode, new MD5PasswordEncoder());  // user校验密码用，为了兼容cs，ass自定义MD5 PasswordEncoder
		encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()); // oauth_client查询校验编码用
		PasswordEncoder delegatingPasswordEncoder =
				new DelegatingPasswordEncoder(idForEncode, encoders);
		return  delegatingPasswordEncoder;
		// return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	}


	@Bean
	@Override
	@SneakyThrows
	public AuthenticationManager authenticationManagerBean() {
		return super.authenticationManagerBean();
	}
}
