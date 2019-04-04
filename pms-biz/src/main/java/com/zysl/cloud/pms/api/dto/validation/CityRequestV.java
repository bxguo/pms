package com.zysl.cloud.pms.api.dto.validation;

import com.zysl.cloud.pms.common.validator.IValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
public class CityRequestV implements IValidator {

    @NotNull
    private Long id;

    @Override
    public void customizedValidate(List<String> errors, Integer useCase) {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityRequestV{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
