package com.zysl.cloud.pms.share.validator;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: bxguo
 * @time: 2019/3/28 16:55
 */
@Component
public class BeanValidator implements Serializable {

    private static final long serialVersionUID = 3721683409138322618L;

    public static final Integer CASE_DEFAULT = 0;
    public static final Integer CASE_CTREATE = 1;
    public static final Integer CASE_UPDATE = 2;

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Autowired
    private transient Validator validator;


    public List<String> validate(IValidator data, Integer useCase) {
        List<String> errors = null;
        try {
            validateWithException(validator, data);
        } catch (ConstraintViolationException e) {
            errors = extractPropertyAndMessageAsList(e, ": ");
        }
        if (errors == null) {
            errors = new ArrayList<>();
        }
        data.customizedValidate(errors, useCase);
        return errors;
    }
    private static void validateWithException(Validator validator, Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    private static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
        ArrayList<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getPropertyPath() + separator + violation.getMessage());
        }
        return errors;
    }


}
