package com.auth.service.web.model.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户角色表PO实体
 *
 * 表：auth_user_role
 * @author chenqs
 * @date 2022-03-08 15:34:30
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthUseRolePO {

    /** 用户ID */
    private Integer userId;

    /** 角色ID */
    private Integer roleId;
}