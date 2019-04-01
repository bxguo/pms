package com.zysl.cloud.pms.api.service;

import com.zysl.cloud.pms.api.dto.common.BaseResponse;
import com.zysl.cloud.pms.api.dto.HelloRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 健康服务
 * @author: bxguo
 * @time: 2019/3/19 16:31
 */
@RequestMapping(value = "api/helloSvc")
public interface HelloService {
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
    @PostMapping("/hello")
    BaseResponse<String> hello(@RequestBody HelloRequest request);


}
