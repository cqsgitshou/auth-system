package com.auth.client.web.model.dto;

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


	/** 简介 */
	private String phone;

	/** 头像 */
	private String avatar;


	/** 创建时间 */
	private LocalDateTime createTime;


	/** 0-正常，9-锁定 */
	private String lockFlag;

}
