package com.auth.service.web.service;

import com.auth.service.web.model.param.AuthUsersInsert;
import com.auth.commons.global.model.dto.Result;

/**
 * OauthClientDetailsService
 *
 * @author chenqs
 * @date 2022/3/8
 */
public interface AuthUsersService {
	Result insert(AuthUsersInsert insert);
}
