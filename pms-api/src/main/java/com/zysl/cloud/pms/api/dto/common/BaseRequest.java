package com.zysl.cloud.pms.api.dto.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:45
 */
@Getter
@Setter
@ApiModel(description = "请求基础类对象")
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -4407371080211718117L;
}
