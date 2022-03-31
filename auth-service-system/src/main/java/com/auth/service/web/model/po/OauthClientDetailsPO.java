package com.auth.service.web.model.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 终端信息表PO实体
 *
 * 表：auth_oauth_client_details
 * @author chenqs
 * @date 2022-03-08 14:47:14
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OauthClientDetailsPO {

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