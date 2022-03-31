package com.auth.service.web.controller.admin;

import com.alibaba.fastjson.JSON;

import com.auth.commons.global.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 授权
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	/**
	 * 认证页面
	 * @param modelAndView
	 * @param error 表单登录失败处理回调的错误信息
	 * @return ModelAndView
	 */
	@GetMapping("/login")
	public ModelAndView require(ModelAndView modelAndView, @RequestParam(required = false) String error) {
		modelAndView.setViewName("ftl/login");
		modelAndView.addObject("error", error);
	// 	modelAndView.addObject("client_id", client_id);
		return modelAndView;
	}
	@GetMapping("/success")
	public ModelAndView success(ModelAndView modelAndView, @RequestParam(required = false) String error) {
		modelAndView.setViewName("ftl/success");
		modelAndView.addObject("error", error);
		return modelAndView;
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


	@GetMapping("/user")
	@PreAuthorize("hasRole('ADMIN')")
	public Result user() {

		return Result.success();
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
