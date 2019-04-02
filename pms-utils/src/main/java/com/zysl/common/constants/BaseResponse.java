package com.zysl.common.constants;


import com.zysl.common.enums.RespCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 11:40
 */
@Getter
@Setter
public class BaseResponse<T extends Serializable> implements Serializable {
    @ApiModelProperty(value = "响应码", name = "code")
    private Integer code;
    @ApiModelProperty(value = "响应消息", name = "msg")
    private String msg;
    @ApiModelProperty(value = "响应数据", name = "model")
    private T model;
    @ApiModelProperty(value = "校验信息", name = "validations")
    private List<String> validations;

    public BaseResponse() {
    }

    public BaseResponse(T model) {
        this.model = model;
    }

    public void setSuccess(Boolean success){
        this.setCode(success? RespCodeEnum.SUCCESS.getCode():RespCodeEnum.FAILED.getCode());
    }
    public Boolean success(Boolean success){
        return RespCodeEnum.SUCCESS.getCode().equals(this.code);
    }
}
