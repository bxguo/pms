package com.zysl.cloud.pms.api.service.impl;

import com.zysl.cloud.pms.api.dto.req.CityRequest;
import com.zysl.cloud.pms.api.dto.resp.CityDTO;
import com.zysl.cloud.pms.api.dto.validation.CityRequestV;
import com.zysl.cloud.pms.api.service.CityService;
import com.zysl.cloud.pms.domain.query.CityQuery;
import com.zysl.cloud.pms.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zysl.cloud.pms.common.constants.BasePaginationResponse;
import com.zysl.cloud.pms.common.constants.BaseResponse;
import com.zysl.cloud.pms.common.service.provider.ServiceProvider;
import com.zysl.cloud.pms.common.utils.BeanCopyUtil;

/**
 * @author: bxguo
 * @time: 2019/3/29 14:00
 */
@RestController
public class CityController extends BaseApiController implements CityService {
    @Autowired
    private ICityService cityService;
    @Override
    public BasePaginationResponse<CityDTO> queryCityInfoByName(CityRequest request) {
        /*return ServiceProvider.call(request, CityRequestV.class, CityDTO.class,req -> {
            return new CityDTO();
        });*/
        return null;
    }

    @Override
    public BaseResponse<CityDTO> queryCityInfoById(CityRequest request) {
        return ServiceProvider.call(request, CityRequestV.class, CityDTO.class
                , req -> cityService.queryCityInfoById(BeanCopyUtil.copy(req, CityQuery.class)));
    }
}
