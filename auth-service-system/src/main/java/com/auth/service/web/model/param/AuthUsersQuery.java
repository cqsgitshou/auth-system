package com.auth.service.web.model.param;

import com.auth.commons.global.model.dto.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户表查询
 *
 * @author : chenqs
 * @date: 2022-03-08 15:35:35
 **/
@Getter
@Setter
public class AuthUsersQuery extends BasePage {

    /**
     * 查询关键字
     **/
    private String keyword;
}
