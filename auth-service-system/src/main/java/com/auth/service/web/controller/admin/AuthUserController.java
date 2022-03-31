package com.auth.service.web.controller.admin;

import com.auth.commons.global.model.dto.Result;
import com.auth.service.web.model.param.AuthUsersInsert;
import com.auth.service.web.service.AuthUsersService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * client
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/admin/authUser")
public class AuthUserController {

	@Autowired
	private AuthUsersService authUsersService;

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Result addAuthUser(@RequestBody  AuthUsersInsert authUsersInsert) {

		authUsersService.insert(authUsersInsert);
		return Result.success();
	}
}
