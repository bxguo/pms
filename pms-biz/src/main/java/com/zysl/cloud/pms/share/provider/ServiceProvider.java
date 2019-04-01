package com.zysl.cloud.pms.share.provider;

import com.google.common.collect.Lists;
import com.zysl.cloud.pms.api.dto.common.BaseResponse;
import com.zysl.cloud.pms.api.dto.common.exception.AppLogicException;
import com.zysl.cloud.pms.api.enumerate.RespCodeEnum;
import com.zysl.cloud.pms.share.BeanCopyUtil;
import com.zysl.cloud.pms.share.SpringContextUtil;
import com.zysl.cloud.pms.share.validator.BeanValidator;
import com.zysl.cloud.pms.share.validator.IValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 16:41
 */
public class ServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(ServiceProvider.class);

    private static final String ERROR_FORMAT_STRING = "[call with error] class=%s, method=%s, params=%s, error=%s";
    private static final String EXCEPTION_FORMAT_STRING = "[call with exption] class=%s, method=%s, params=%s, exception=%s";
    private static final String START_FORMAT_STRING = "[call start] class=%s, method=%s, params=%s";
    private static final String END_FORMAT_STRING = "[call end] class=%s, method=%s, used=%s, resp=%s";

    private ServiceProvider() { }

    public static <R, S extends IValidator, P, D extends Serializable>BaseResponse<D> call(P req,
            Class<S> reqVCls, Class<D> respCls, ServiceOperateCallPredit<P, R> predit){
        return call(req, reqVCls, respCls, predit, BeanValidator.CASE_DEFAULT);
    }

    public static <R, S extends IValidator, P, D extends Serializable>BaseResponse<D> call(P req,
           Class<S> reqVCls, Class<D> respCls, ServiceOperateCallPredit<P, R> predit, Integer useCase){
        Long start = System.currentTimeMillis();
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String clsName = stack[3].getClassName().substring(stack[3].getClassName().lastIndexOf('.')+1);
        String methodName = stack[3].getMethodName();
        logger.info(String.format(START_FORMAT_STRING, clsName, methodName, req));
        BaseResponse<D> resp = new BaseResponse<>();
        List<String> validate = Lists.newArrayList();
        if (reqVCls !=  null) {
            S validator = BeanCopyUtil.copy(req, reqVCls);
            BeanValidator beanValidator = SpringContextUtil.getBean("beanValidator", BeanValidator.class);
            validate = beanValidator.validate(validator, useCase);
        }
        if (CollectionUtils.isEmpty(validate)) {
            try {
                resp.setModel(BeanCopyUtil.copy(predit.solve(req), respCls));
                resp.setSuccess(true);
            } catch (AppLogicException e) {
                logger.warn(String.format(ERROR_FORMAT_STRING, clsName, methodName, req, e.getMessage()));
                resp.setCode(e.getExceptionCode());
                resp.setMsg(e.getMessage());
            } catch (Exception e) {
                logger.error(String.format(EXCEPTION_FORMAT_STRING, clsName, methodName, req, e.getMessage()),e);
                resp.setCode(RespCodeEnum.FAILED.getCode());
                resp.setMsg(RespCodeEnum.FAILED.getDesc());
            }
        }else {
            resp.setCode(RespCodeEnum.ILLEGAL_PARAMETER.getCode());
            resp.setMsg(RespCodeEnum.ILLEGAL_PARAMETER.getDesc());
            resp.setValidations(validate);
        }
        Long used = System.currentTimeMillis() - start;
        logger.info(String.format(END_FORMAT_STRING, clsName, methodName, used, resp));
        return resp;
    }
}
