package com.zysl.cloud.pms.common.constants;

import com.zysl.cloud.pms.common.enums.RespCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:45
 */
@Getter
@Setter
@ApiModel(description = "分页请求基础类对象")
public class BasePaginationResponse<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5497788475561861527L;

    @ApiModelProperty(value = "响应码", position = 0)
    private Integer code;
    @ApiModelProperty(value = "响应消息", position = 1)
    private String msg;
    @ApiModelProperty(value = "响应数据", position = 2)
    private List<T> modelList;
    @ApiModelProperty(value = "校验信息", position = 4)
    private List<String> validations;
    @ApiModelProperty(value = "总条数", position = 5)
    private Long totalCount;
    @ApiModelProperty(value = "当前页码", position = 6)
    private Integer pageCount;

    public void setSuccess(Boolean success){
        this.setCode(success? RespCodeEnum.SUCCESS.getCode():RespCodeEnum.FAILED.getCode());
    }
    public Boolean success(Boolean success){
        return RespCodeEnum.SUCCESS.getCode().equals(this.code);
    }
}
