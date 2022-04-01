package com.auth.service.web.model.param;

import com.auth.commons.global.model.dto.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色表查询
 *
 * @author : chenqs
 * @date: 2022-04-01 13:42:09
 **/
@Getter
@Setter
public class AuthUserRoleQuery extends BasePage {

    /**
     * 查询关键字
     **/
    private String keyword;
}
