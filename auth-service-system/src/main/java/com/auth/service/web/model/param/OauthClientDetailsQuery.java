package com.auth.service.web.model.param;

import com.auth.commons.global.model.dto.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 终端信息表查询
 *
 * @author : chenqs
 * @date: 2022-03-08 14:47:14
 **/
@Getter
@Setter
public class OauthClientDetailsQuery extends BasePage {

    /**
     * 查询关键字
     **/
    private String keyword;
}
