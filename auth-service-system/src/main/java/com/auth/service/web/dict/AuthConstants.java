package com.auth.service.web.dict;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/8
 */
public interface AuthConstants {

	/**
	 * 客户端
	 */
	 String CLIENT_DETAILS_KEY = "auth:oauth:client:details";

	/**
	 * sys_oauth_client_details 表的字段，不包括client_id、client_secret
	 */
	String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
			+ "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
			+ "refresh_token_validity, additional_information, autoapprove";

	/**
	 * JdbcClientDetailsService 查询语句
	 */
	String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from auth_oauth_client_details";

	/**
	 * 默认的查询语句
	 */
	String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

	/**
	 * 按条件client_id 查询
	 */
	String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

	/**
	 * 32位MD5加密
	 */
	String ENCONDING_ID = "{MD5_32}";
	String MD5 = "MD5_32";
}
