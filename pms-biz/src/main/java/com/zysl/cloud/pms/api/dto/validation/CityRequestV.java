package com.zysl.cloud.pms.api.dto.validation;

import com.zysl.cloud.pms.common.validator.IValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/29 13:46
 */
@Getter
@Setter
public class CityRequestV implements IValidator {

    @NotBlank
    private String cityName;

    @Override
    public void customizedValidate(List<String> errors, Integer useCase) {

    }
}
