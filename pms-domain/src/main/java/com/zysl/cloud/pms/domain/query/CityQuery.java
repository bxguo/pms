package com.zysl.cloud.pms.domain.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
public class CityQuery{
    private Long id;
    private String cityName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityQuery{");
        sb.append("id=").append(id);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
