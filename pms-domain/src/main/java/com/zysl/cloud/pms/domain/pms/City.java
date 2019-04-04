package com.zysl.cloud.pms.domain.pms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
public class City implements Serializable {
    private static final long serialVersionUID = 4511103456997774356L;
    private Long id;
    private Long provinceId;
    private String cityName;
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
