package com.zysl.cloud.pms.api.service;

import com.zysl.cloud.pms.api.dto.Common.BaseResponse;
import com.zysl.cloud.pms.api.dto.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康服务
 * @author: bxguo
 * @time: 2019/3/19 16:31
 */
@RequestMapping(value = "api/helloSvc")
public interface IHelloService {
    /**
     * 检查是否还活着
     * @return
     */
    @GetMapping("/checkHealth")
    String checkHealth();

    /**
     * 测试
     * @param request
     * @return
     */
    @GetMapping("/hello")
    BaseResponse<String> hello(@RequestBody HelloRequest request);


}
