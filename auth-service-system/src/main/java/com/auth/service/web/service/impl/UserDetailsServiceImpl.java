package com.auth.service.web.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.auth.service.web.dao.AuthRoleMapper;
import com.auth.service.web.dao.OauthUserMapper;
import com.auth.service.web.dict.AuthConstants;
import com.auth.service.web.model.dto.OauthUserDetail;
import com.auth.service.web.model.dto.UserInfo;
import com.auth.service.web.model.po.AuthRolePO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 授权查询
 *
 * @author chenqs
 * @date 2022/2/28
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OauthUserMapper oauthUserMapper;

	@Autowired
	private AuthRoleMapper authRoleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OauthUserDetail oauthUserDetail = oauthUserMapper.queryUserByUsername(username);

		// 设置角色列表
		List<AuthRolePO> roles = authRoleMapper.findRolesByUserId(oauthUserDetail.getUserId());

		Set<String> dbAuthsSet = new HashSet<>();
		if (ArrayUtil.isNotEmpty(roles)){
			// 获取角色
			roles.forEach(role -> dbAuthsSet.add(role.getRoleCode()));
		}

		List<GrantedAuthority> authorities =  AuthorityUtils
				.createAuthorityList(dbAuthsSet.toArray(new String[0]));

		//
		return new UserInfo(oauthUserDetail.getUserId(),oauthUserDetail.getUsername(), AuthConstants.ENCONDING_ID + oauthUserDetail.getPassword(), authorities);
	}

}
