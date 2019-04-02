package com.zysl.common.constants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:45
 */
@Getter
@Setter
@ApiModel(description = "分页请求基础类对象")
public class BasePaginationRequest implements Serializable {

    private static final long serialVersionUID = 6201373346470846366L;
    @ApiModelProperty(value = "起始页", name = "pageIndex", required = true, example = "1", position = 0)
    private Integer pageIndex;
    @ApiModelProperty(value = "每页数据条数", name = "pageSize", required = true, example = "20", position = 1)
    private Integer pageSize;

}
