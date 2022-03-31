package com.auth.service.web.dao;

import com.auth.service.web.model.dto.AuthUseRoleBrief;
import com.auth.service.web.model.dto.AuthUseRoleDetail;
import com.auth.service.web.model.param.AuthUseRoleQuery;
import com.auth.service.web.model.po.AuthUseRolePO;

import java.util.List;

/**
 * 用户角色表
 *
 * 表名：  auth_user_role
 * @author  chenqs
 * @date 2022-03-08 15:34:30
 */
public interface AuthUseRoleMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(AuthUseRolePO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(AuthUseRolePO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return AuthUseRole
     **/
    AuthUseRoleDetail queryByID(Integer id);

    /**
     * 查询列表
     *
     * @return AuthUseRole
     **/
    List<AuthUseRoleBrief> list(AuthUseRoleQuery query);
}