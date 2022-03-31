package com.auth.service.web.model.param;

import com.auth.commons.global.model.dto.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色表查询
 *
 * @author : chenqs
 * @date: 2022-03-08 15:37:33
 **/
@Getter
@Setter
public class AuthRoleQuery extends BasePage {

    /**
     * 查询关键字
     **/
    private String keyword;
}
