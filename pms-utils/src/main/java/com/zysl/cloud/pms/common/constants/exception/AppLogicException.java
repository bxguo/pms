package com.zysl.cloud.pms.common.constants.exception;


import com.zysl.cloud.pms.common.enums.RespCodeEnum;
import lombok.Getter;

/**
 * @author: bxguo
 * @time: 2019/3/28 15:57
 */
@Getter
public class AppLogicException extends RuntimeException {

    private static final long serialVersionUID = 1748419785672080766L;

    private final Integer exceptionCode;

    public AppLogicException() {
        super();
        this.exceptionCode = RespCodeEnum.FAILED.getCode();
    }

    public AppLogicException(String msg, Integer exceptionCode) {
        super(msg);
        this.exceptionCode = exceptionCode;
    }
}
