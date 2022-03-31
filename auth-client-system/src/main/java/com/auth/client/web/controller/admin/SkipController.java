package com.auth.client.web.controller.admin;

import com.auth.commons.global.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 跳过授权
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/auth/skip")
public class SkipController {


	@GetMapping("test")
	public Result user() {

		return Result.success("test");
	}



}
