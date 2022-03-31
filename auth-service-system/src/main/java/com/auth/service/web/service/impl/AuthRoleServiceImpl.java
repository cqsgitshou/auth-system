package com.auth.service.web.service.impl;

import com.auth.commons.global.model.dto.Result;
import com.auth.service.web.dao.AuthRoleMapper;
import com.auth.service.web.model.param.AuthRoleInsert;
import com.auth.service.web.model.po.AuthRolePO;
import com.auth.service.web.service.AuthRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/31
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService {

	@Autowired
	private AuthRoleMapper authRoleMapper;
	@Override
	public Result insert(AuthRoleInsert authRoleInsert) {
		AuthRolePO insert = new AuthRolePO();
		BeanUtils.copyProperties(authRoleInsert,insert);
		insert.setCreateTime(LocalDateTime.now());
		return Result.success(authRoleMapper.insert(insert));
	}
}
