package com.auth.client.web.model.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表查询
 *
 * @author : chenqs
 * @date: 2022-03-02 14:16:15
 **/
@Getter
@Setter
public class OauthUserQuery  {

    /**
     * 查询关键字
     **/
    private String keyword;
}
