package com.zysl.cloud.pms.share.validator;

import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 16:56
 */
public interface IValidator {
    void customizedValidate(List<String> errors, Integer useCase);
}
