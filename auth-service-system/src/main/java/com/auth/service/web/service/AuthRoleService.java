package com.auth.service.web.service;

import com.auth.commons.global.model.dto.Result;
import com.auth.service.web.model.param.AuthRoleInsert;
import com.auth.service.web.model.param.AuthUsersInsert;

/**
 * AuthRoleService
 *
 * @author chenqs
 * @date 2022/3/8
 */
public interface AuthRoleService {
	Result insert(AuthRoleInsert authRoleInsert);
}
