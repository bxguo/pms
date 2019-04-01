package com.zysl.cloud.pms.api.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
@ApiModel(value = "城市名称")
public class CityRequest {

    @ApiModelProperty(value = "城市名称", name = "cityName", dataType = "String")
    private String cityName;
    @ApiModelProperty(value = "主键", name = "id", dataType = "Long")
    private Long id;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityRequest{");
        sb.append("cityName='").append(cityName).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
