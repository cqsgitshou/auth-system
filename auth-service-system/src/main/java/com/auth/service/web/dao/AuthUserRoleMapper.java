package com.auth.service.web.dao;

import com.auth.service.web.model.po.AuthUserRolePO;
import com.auth.service.web.model.param.AuthUserRoleQuery;
import com.auth.service.web.model.dto.AuthUserRoleBrief;
import com.auth.service.web.model.dto.AuthUserRoleDetail;
import java.util.List;

/**
 * 用户角色表
 *
 * 表名：  auth_user_role
 * @author  chenqs
 * @date 2022-04-01 13:42:09
 */
public interface AuthUserRoleMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(AuthUserRolePO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(AuthUserRolePO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return AuthUserRole
     **/
    AuthUserRoleDetail queryByID(Integer id);

    /**
     * 查询列表
     *
     * @return AuthUserRole
     **/
    List<AuthUserRoleBrief> list(AuthUserRoleQuery query);
}