package com.auth.service.web.service.impl;

import com.auth.commons.global.model.dto.Result;
import com.auth.service.web.dao.AuthRoleMapper;
import com.auth.service.web.dao.AuthUserRoleMapper;
import com.auth.service.web.model.param.AuthRoleInsert;
import com.auth.service.web.model.po.AuthRolePO;
import com.auth.service.web.model.po.AuthUserRolePO;
import com.auth.service.web.service.AuthRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private AuthUserRoleMapper authUserRoleMapper;
	@Autowired
	private AuthRoleService authRoleService;

	@Override
	@Transactional
	public Result insert(AuthRoleInsert authRoleInsert) {
		AuthRolePO insert = new AuthRolePO();
		BeanUtils.copyProperties(authRoleInsert,insert);
		insert.setCreateTime(LocalDateTime.now());
		authRoleMapper.insert(insert);
		for(int i=3;i<6;i++){

			try {
				authRoleService.test(i);
			}catch (Exception e){

			}

		}
		return Result.success();
	}

	@Override
	 @Transactional(propagation = Propagation.REQUIRES_NEW)
	// @Transactional
	public void test(int i) {
		if(i==5){
			throw new RuntimeException("回滚");
		}
			AuthUserRolePO insert = new AuthUserRolePO();
			insert.setRoleId(i);
			insert.setUserId(i);
			authUserRoleMapper.insert(insert);

	}
}
