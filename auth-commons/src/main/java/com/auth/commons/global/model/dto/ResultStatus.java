package com.auth.commons.global.model.dto;

/**
 *
 */
public enum ResultStatus {


    /**
     *
     */
    Success(200, "业务处理成功"),
    Accepted(202, "业务处理成功，等待服务器通知处理"),

    Failure(400, "业务处理失败"),


    Internal_Server_Error(500, "服务器内部异常"),

    ;

    public final int code;
    public final String name;

    ResultStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public short shortCode() {
        return (short) code;
    }

}
