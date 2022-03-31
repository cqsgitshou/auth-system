package com.auth.service.web.model.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表创建
 *
 * @author : chenqs
 * @date: 2022-03-08 15:35:35
 **/
@Getter
@Setter
public class AuthUsersInsert {
	/** 主键ID */
	private Integer userId;

	/** 用户名 */
	private String username;

	/**  */
	private String password;

	/** 随机盐 */
	private String salt;

	/** 简介 */
	private String phone;

	/** 头像 */
	private String avatar;

	/** 部门ID */
	private Integer deptId;

}
