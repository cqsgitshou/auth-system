package com.auth.service.web.service.impl;

import com.auth.service.web.dict.AuthConstants;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/1
 */
public class ZimouyunClientDetailsService  extends JdbcClientDetailsService {
	public ZimouyunClientDetailsService(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	@Cacheable(value = AuthConstants.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
	public ClientDetails loadClientByClientId(String clientId) {
		ClientDetails clientDetails = super.loadClientByClientId(clientId);

		return clientDetails;
	}
}
