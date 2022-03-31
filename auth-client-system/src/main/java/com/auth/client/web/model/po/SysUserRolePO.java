package com.auth.client.web.model.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户角色表PO实体
 *
 * 表：sys_user_role
 * @author chenqs
 * @date 2022-03-04 16:16:20
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SysUserRolePO {

    /** 用户ID */
    private Integer userId;

    /** 角色ID */
    private Integer roleId;
}