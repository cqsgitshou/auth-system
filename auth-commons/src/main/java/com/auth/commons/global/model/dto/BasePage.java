package com.auth.commons.global.model.dto;

/**
 * @module 分页基础类

 */
public class BasePage {

    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 单页显示数量
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
