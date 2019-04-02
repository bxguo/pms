package com.zysl.cloud.pms.api.dto;

import com.zysl.cloud.pms.common.constants.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:44
 */
@Getter
@Setter
public class HelloRequest extends BaseRequest {

    private static final long serialVersionUID = -2745297433810770005L;

    private String name;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HelloRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
