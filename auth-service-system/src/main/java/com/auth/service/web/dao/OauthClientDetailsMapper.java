package com.auth.service.web.dao;

import com.auth.service.web.model.dto.OauthClientDetailsBrief;
import com.auth.service.web.model.dto.OauthClientDetailsDetail;
import com.auth.service.web.model.param.OauthClientDetailsQuery;
import com.auth.service.web.model.po.OauthClientDetailsPO;

import java.util.List;

/**
 * 终端信息表
 *
 * 表名：  auth_oauth_client_details
 * @author  chenqs
 * @date 2022-03-08 14:47:14
 */
public interface OauthClientDetailsMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(OauthClientDetailsPO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(OauthClientDetailsPO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return OauthClientDetails
     **/
    OauthClientDetailsDetail queryByID(String id);

    /**
     * 查询列表
     *
     * @return OauthClientDetails
     **/
    List<OauthClientDetailsBrief> list(OauthClientDetailsQuery query);
}