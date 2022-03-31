package com.auth.service.web.controller.admin;

import com.auth.commons.global.model.dto.Result;
import com.auth.service.web.model.param.AuthRoleInsert;
import com.auth.service.web.model.param.AuthUseRoleInsert;
import com.auth.service.web.model.param.OauthClientDetailsInsert;
import com.auth.service.web.service.AuthRoleService;
import com.auth.service.web.service.OauthClientDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * role
 *
 * @author chenqs
 * @date 2022/2/25
 */
@Slf4j
@RestController
@RequestMapping("/admin/role")
public class AuthRoleController {

	@Autowired
	private AuthRoleService authRoleService;
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Result addRole(@RequestBody AuthRoleInsert authRoleInsert) {
		authRoleService.insert(authRoleInsert);
		return Result.success();
	}
}
