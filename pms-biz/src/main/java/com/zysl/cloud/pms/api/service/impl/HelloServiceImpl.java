package com.zysl.cloud.pms.api.service.impl;

import com.zysl.cloud.pms.api.dto.Common.BaseResponse;
import com.zysl.cloud.pms.api.dto.HelloRequest;
import com.zysl.cloud.pms.api.dto.validation.HelloRequestV;
import com.zysl.cloud.pms.api.service.IHelloService;
import com.zysl.cloud.pms.share.provider.ServiceProvider;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: bxguo
 * @time: 2019/3/28 16:27
 */
@RestController
public class HelloServiceImpl extends  BaseApiController implements IHelloService {

    @Override
    public String checkHealth() {
        return "pms-cloud 存活 :::"+new Date();
    }

    @Override
    public BaseResponse<String> hello(HelloRequest request) {
        return ServiceProvider.call(request, HelloRequestV.class, String.class, req -> {
            return "new" + req.getName();
        });
    }
}
