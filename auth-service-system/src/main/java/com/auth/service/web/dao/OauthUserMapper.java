package com.auth.service.web.dao;

import com.auth.service.web.model.dto.OauthUserBrief;
import com.auth.service.web.model.dto.OauthUserDetail;
import com.auth.service.web.model.param.OauthUserQuery;
import com.auth.service.web.model.po.OauthUserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * 表名：  oauth_users
 * @author  chenqs
 * @date 2022-03-02 14:16:15
 */
public interface OauthUserMapper {

    /**
     * 全字段新增
     *
     * @param insert
     * @return 新增条数
     **/
    int insert(OauthUserPO insert);

    /**
     * 根据主键动态修改
     *
     * @param update
     * @return 修改条数
     **/
    int update(OauthUserPO update);

    /**
     * 根据主键查询
     *
     * @param id
     * @return OauthUser
     **/
    OauthUserDetail queryByID(Integer id);

    /**
     * 查询列表
     *
     * @return OauthUser
     **/
    List<OauthUserBrief> list(OauthUserQuery query);

    /**
     * loadUserByUsername
     * @param username
     * @return
     */
    OauthUserDetail queryUserByUsername(@Param("username") String username);
}