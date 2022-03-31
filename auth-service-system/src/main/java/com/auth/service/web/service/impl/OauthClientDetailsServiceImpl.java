package com.auth.service.web.service.impl;

import com.auth.service.web.service.OauthClientDetailsService;
import com.auth.service.web.dao.OauthClientDetailsMapper;
import com.auth.service.web.model.param.OauthClientDetailsInsert;
import com.auth.service.web.model.po.OauthClientDetailsPO;
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
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

	@Autowired
	private OauthClientDetailsMapper oauthClientDetailsMapper;
	@Override
	public Result insert(OauthClientDetailsInsert insert) {
		OauthClientDetailsPO po = new OauthClientDetailsPO();
		BeanUtils.copyProperties(insert,po);
		oauthClientDetailsMapper.insert(po);
		return Result.success();
	}
}
