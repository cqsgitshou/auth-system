//package com.zimo.auth.web.service.impl;
//
//import com.google.common.collect.Lists;
//import com.zimo.auth.web.model.dto.AdminUser;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
///**
// * admin登录
// *
// * @author chenqs
// * @date 2022/3/8
// */
//// @Component
//public class ZimoyunAuthenticationProvider implements AuthenticationProvider {
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		// 获取用户输入的用户名和密码
//		String username = authentication.getName();
//		String password = authentication.getCredentials().toString();
//		AdminUser userDetails = new AdminUser() ;
//		userDetails.setUsername(username);
//		return new UsernamePasswordAuthenticationToken(userDetails,password, Lists.newArrayList());
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return true;
//	}
//}
