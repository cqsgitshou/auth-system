package com.auth.service.web.model.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 终端信息表创建
 *
 * @author : chenqs
 * @date: 2022-03-08 14:47:14
 **/
@Getter
@Setter
public class OauthClientDetailsInsert {
	/**  */
	private String clientId;

	/**  */
	private String resourceIds;

	/**  */
	private String clientSecret;

	/**  */
	private String scope;

	/**  */
	private String authorizedGrantTypes;

	/**  */
	private String webServerRedirectUri;

	/**  */
	private String authorities;

	/**  */
	private Integer accessTokenValidity;

	/**  */
	private Integer refreshTokenValidity;

	/**  */
	private String additionalInformation;

	/**  */
	private String autoapprove;
}
