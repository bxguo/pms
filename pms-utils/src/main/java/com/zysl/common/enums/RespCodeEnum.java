package com.zysl.common.enums;

import lombok.Getter;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:35
 */
@Getter
public enum RespCodeEnum {

    SUCCESS(200,"成功"),
    ILLEGAL_PARAMETER(400,"请求参数错误"),
    AUTHFAILED(401,"请求需要身份认证"),
    FORBIDDEN(403,"请求被禁止"),
    NOT_EXISTED(404,"找不到资源"),
    FAILED(500,"服务器内部错误");

    private Integer code;
    private String desc;

    RespCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }}
