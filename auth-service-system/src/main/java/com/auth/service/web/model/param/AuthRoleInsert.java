package com.auth.service.web.model.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色表创建
 *
 * @author : chenqs
 * @date: 2022-03-08 15:37:33
 **/
@Getter
@Setter
public class AuthRoleInsert {

	private String roleName;
	private String roleCode;
	private String roleDesc;

}
