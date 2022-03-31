package com.auth.service.config.datasource;


import com.auth.service.web.dict.AuthConstants;
import com.auth.service.web.model.dto.UserInfo;
import com.auth.service.web.service.impl.ZimouyunClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * OAuth的授权认证服务器配置
 * @author chenqs
 * @date: 202203
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	// Resource
	//private  UserDetailsService userDetailsService;
	@Resource
	private  AuthenticationManager authenticationManager;
	@Resource
	private  DataSource dataSource;
	@Resource
	private UserDetailsService userDetailsService;
	@Resource
	private RedisConnectionFactory redisConnectionFactory;
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	/**
	 * 配置令牌端点(Token Endpoint)的安全约束
	 * @param oauthServer
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		//  获取令牌不需要认证
		oauthServer.allowFormAuthenticationForClients()
				.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");

	}

	@Override
	/**
	 * 用来配置客户端详情服务（ClientDetailsService），
	 */
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		// 能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息；
		ZimouyunClientDetailsService clientDetailsService = new ZimouyunClientDetailsService(dataSource);
		clientDetailsService.setSelectClientDetailsSql(AuthConstants.DEFAULT_SELECT_STATEMENT);
		clientDetailsService.setFindClientDetailsSql(AuthConstants.DEFAULT_FIND_STATEMENT);
		clients.withClientDetails(clientDetailsService);
	}


	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

		endpoints
				.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
				/// 如果TokenStore的注入类型是RedisTokenStore，则生成的JWT会存入redis中
				//　如果TokenStore的注入类型是JwtTokenStore，或者endpoints不设置TokenStore，那么生成的JWT在内存中。
				.tokenStore(tokenStore())
				// add only jwt
				.accessTokenConverter(jwtAccessTokenConverter)
				 // .tokenEnhancer(tokenEnhancer())

				 .userDetailsService(userDetailsService)
				.authenticationManager(authenticationManager)
				.reuseRefreshTokens(false)
				.pathMapping("/oauth/confirm_access", "/token/confirm_access");

	}
	@Bean
	public TokenStore tokenStore() {

		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	private TokenStore redisAccessTokenStore() {
		RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
		tokenStore.setPrefix("auth:access");
		// tokenStore.setSerializationStrategy();

		return tokenStore;
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		//配置JWT使用的秘钥
		tokenConverter.setSigningKey("zimoyuncloud");


		//设置用户信息转换器，默认getPrincipal是username
		DefaultAccessTokenConverter accessTokenConverter = (DefaultAccessTokenConverter)tokenConverter.getAccessTokenConverter();
		UserAuthenticationConverter userTokenConverter = new AuthUserAuthenticationConverter();
		accessTokenConverter.setUserTokenConverter(userTokenConverter);

		return tokenConverter;
	}

	/**
	 * jwtToken时不用重构TokenEnhancer  当redis存储 accessToken ，如果想往令牌中加入自定义用户信息，例如登录时间点，AuthorizationServerEndpointsConfigurer可以配置以下类：
	 * @return
	 */
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return (accessToken, authentication) -> {
			final Map<String, Object> additionalInfo = new HashMap<>(4);

			UserInfo userDetails   = (UserInfo)authentication.getUserAuthentication().getPrincipal();

			additionalInfo.put("user_id", userDetails.getUserId());
			additionalInfo.put("username", userDetails.getUsername());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
			return accessToken;
		};
	}
}
