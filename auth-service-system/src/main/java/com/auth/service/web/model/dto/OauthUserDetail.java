package com.auth.service.web.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 用户表详情
 *
 * @author : chenqs
 * @date: 2022-03-02 14:16:15
 **/
@Getter
@Setter
public class OauthUserDetail {
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

	/** 创建时间 */
	private LocalDateTime createTime;

	/** 修改时间 */
	private LocalDateTime updateTime;

	/** 0-正常，9-锁定 */
	private String lockFlag;

	/** 0-正常，1-删除 */
	private String delFlag;
}
