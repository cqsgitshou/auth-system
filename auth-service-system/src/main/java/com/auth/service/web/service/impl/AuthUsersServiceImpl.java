package com.auth.service.web.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.auth.service.web.dao.AuthUsersMapper;
import com.auth.service.web.model.param.AuthUsersInsert;
import com.auth.service.web.model.po.AuthUsersPO;
import com.auth.service.web.service.AuthUsersService;
import com.auth.commons.global.model.dto.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/8
 */
@Service
public class AuthUsersServiceImpl implements AuthUsersService {

	@Autowired
	private AuthUsersMapper authUsersMapper;

	@Override
	public Result insert(AuthUsersInsert insert) {
		AuthUsersPO po = new AuthUsersPO();
		BeanUtils.copyProperties(insert,po);

		// po.setPassword(new BCryptPasswordEncoder().encode(insert.getPassword()));
		po.setPassword(DigestUtil.md5Hex(insert.getPassword()));
		authUsersMapper.insert(po);
		return Result.success();
	}
}
