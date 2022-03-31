package com.auth.service.web.dao;

import com.auth.service.web.model.dto.AuthRoleBrief;
import com.auth.service.web.model.dto.AuthRoleDetail;
import com.auth.service.web.model.param.AuthRoleQuery;
import com.auth.service.web.model.po.AuthRolePO;

import java.util.List;

/**
 * 系统角色表
 *
 * 表名：  auth_role
 * @author  chenqs
 * @date 2022-03-08 15:37:33
 */
public interface AuthRoleMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(AuthRolePO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(AuthRolePO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return AuthRole
     **/
    AuthRoleDetail queryByID(Integer id);

    /**
     * 查询列表
     *
     * @return AuthRole
     **/
    List<AuthRoleBrief> list(AuthRoleQuery query);


    List<AuthRolePO> findRolesByUserId(Integer userId);
}