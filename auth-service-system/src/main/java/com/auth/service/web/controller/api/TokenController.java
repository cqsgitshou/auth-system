package com.auth.service.web.controller.api;

import com.alibaba.fastjson.JSON;

import com.auth.commons.global.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 客户端校验测试
 * main开启注解 @EnableResourceServer  // 成为客户端校验注释
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class TokenController {

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('ADMIN','CLIENT_TEST')") // 接口能访问的角色
	public Result user(Authentication authentication) {
		authentication.getAuthorities();
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)authentication.getDetails();
		System.out.println(JSON.toJSONString(oAuth2AuthenticationDetails));
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println(JSON.toJSONString(userDetails));
		return Result.success(userDetails);
	}

	/**
	 * 认证页面
	 * @return ModelAndView
	 */
	@GetMapping("/user/{username}")
	public String require( @PathVariable String username) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		log.info(JSON.toJSONString(userDetails));
		return String.valueOf(username.equals(userDetails.getUsername()));
	}

	@Autowired
	private CheckTokenEndpoint checkTokenEndpoint;
	@GetMapping("/checkTokenEndpoint")
	public Map<String, ?> checkTokenEndpoint(@RequestParam("token") String value, HttpServletRequest request) {
		String authorizationHeaderValue = request.getHeader("Authorization");
		log.info(authorizationHeaderValue);
		log.info(authorizationHeaderValue.substring("Bearer ".length()));
		return checkTokenEndpoint.checkToken(value);
	}

}
