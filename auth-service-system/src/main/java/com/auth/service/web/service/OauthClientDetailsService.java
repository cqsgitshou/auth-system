package com.auth.service.web.service;

import com.auth.service.web.model.param.OauthClientDetailsInsert;
import com.auth.commons.global.model.dto.Result;

/**
 * OauthClientDetailsService
 *
 * @author chenqs
 * @date 2022/3/8
 */
public interface OauthClientDetailsService {
	Result insert(OauthClientDetailsInsert insert);
}
