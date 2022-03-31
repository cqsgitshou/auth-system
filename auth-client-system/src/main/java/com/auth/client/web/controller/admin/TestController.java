package com.auth.client.web.controller.admin;

import com.alibaba.fastjson.JSON;

import com.auth.client.web.model.dto.OauthUserDetail;
import com.auth.commons.global.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


/**
 * 授权
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/test/user")
public class TestController {


	@GetMapping
	@PreAuthorize("hasAnyRole('CLIENT_TEST')")
	public Result user(Authentication authentication) {
		log.info(JSON.toJSONString(authentication.getPrincipal()));

		OauthUserDetail userDetails = (OauthUserDetail) authentication.getPrincipal();
		log.info(JSON.toJSONString(userDetails));
		return Result.success(authentication.getPrincipal());
	}

	@GetMapping("failure")
	public Result failure() {

		return Result.failure("需要登录");
	}


}
