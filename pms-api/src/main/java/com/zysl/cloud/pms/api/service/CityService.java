package com.zysl.cloud.pms.api.service;


import com.zysl.cloud.pms.api.dto.req.CityRequest;
import com.zysl.cloud.pms.api.dto.resp.CityDTO;
import com.zysl.cloud.pms.common.constants.BasePaginationResponse;
import com.zysl.cloud.pms.common.constants.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: bxguo
 * @time: 2019/3/29 11:44
 */
@RequestMapping(value = "api/city")
public interface CityService {

    @GetMapping("/queryCityInfoByName")
    @ApiOperation(httpMethod = "GET", value = "城市基本信息查询")
    BasePaginationResponse<CityDTO> queryCityInfoByName(@RequestBody CityRequest request);

    @GetMapping("/queryCityInfoById")
    @ApiOperation(httpMethod = "GET", value = "城市基本信息查询")
    BaseResponse<CityDTO> queryCityInfoById(@RequestBody CityRequest request);
}
