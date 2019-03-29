package com.zysl.cloud.pms.api.dto.validation;

import com.zysl.cloud.pms.api.dto.Common.BaseRequest;
import com.zysl.cloud.pms.share.validator.IValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:44
 */
@Getter
@Setter
public class HelloRequestV implements IValidator {
    @NotBlank
    private String name;
    @Override
    public void customizedValidate(List<String> errors, Integer useCase) {

    }
}
