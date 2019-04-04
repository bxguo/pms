package com.zysl.cloud.pms.service;

import com.zysl.cloud.pms.domain.bo.CityBO;
import com.zysl.cloud.pms.domain.query.CityQuery;

import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/29 15:43
 */
public interface ICityService {
    List<CityBO> queryCityInfoByName(CityQuery cityQuery);
    CityBO queryCityInfoById(CityQuery cityQuery);
}
