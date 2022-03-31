package com.auth.client.web.model.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统角色表PO实体
 *
 * 表：sys_role
 * @author chenqs
 * @date 2022-03-04 16:15:54
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SysRolePO {

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