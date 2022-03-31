package com.auth.service.web.dao;

import com.auth.service.web.model.dto.AuthUsersBrief;
import com.auth.service.web.model.dto.AuthUsersDetail;
import com.auth.service.web.model.param.AuthUsersQuery;
import com.auth.service.web.model.po.AuthUsersPO;

import java.util.List;

/**
 * 用户表
 *
 * 表名：  auth_users
 * @author  chenqs
 * @date 2022-03-08 15:35:35
 */
public interface AuthUsersMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(AuthUsersPO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(AuthUsersPO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return AuthUsers
     **/
    AuthUsersDetail queryByID(Integer id);

    /**
     * 查询列表
     *
     * @return AuthUsers
     **/
    List<AuthUsersBrief> list(AuthUsersQuery query);
}