package com.auth.service.web.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/15
 */
public class UserInfo extends User {
	private  Integer userId;
	public UserInfo(Integer userId,String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
