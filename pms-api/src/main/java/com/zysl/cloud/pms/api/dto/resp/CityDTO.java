package com.zysl.cloud.pms.api.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
@ApiModel(value = "城市基本信息")
public class CityDTO implements Serializable {
    private static final long serialVersionUID = 4511103456997774356L;
    @ApiModelProperty(value = "主键", name = "id", dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "省id", name = "provinceId", dataType = "Long")
    private Long provinceId;
    @ApiModelProperty(value = "城市名称", name = "cityName", dataType = "String")
    private String cityName;
    @ApiModelProperty(value = "描述", name = "description", dataType = "String")
    private String description;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityDTO{");
        sb.append("id=").append(id);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
