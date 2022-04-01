package com.auth.service.web.model.po;

import lombok.*;

/**
 * 用户角色表PO实体
 *
 * 表：auth_user_role
 * @author chenqs
 * @date 2022-04-01 13:42:09
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthUserRolePO {

    /** 用户ID */
    private Integer userId;

    /** 角色ID */
    private Integer roleId;
}