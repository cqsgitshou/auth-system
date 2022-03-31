package com.auth.service.web.model.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统角色表PO实体
 *
 * 表：auth_role
 * @author chenqs
 * @date 2022-03-08 15:37:33
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthRolePO {

    /**  */
    private Integer roleId;

    /**  */
    private String roleName;

    /**  */
    private String roleCode;

    /**  */
    private String roleDesc;

    /**  */
    private LocalDateTime createTime;

    /**  */
    private LocalDateTime updateTime;

    /** 删除标识（0-正常,1-删除） */
    private String delFlag;
}