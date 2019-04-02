package com.zysl.cloud.pms.service.impl;

import com.zysl.cloud.pms.dal.dao.pms.mysql.CitySlaveMapper;
import com.zysl.cloud.pms.domain.pg.pms.bo.CityBO;
import com.zysl.cloud.pms.domain.pg.pms.pms.City;
import com.zysl.cloud.pms.domain.pg.pms.query.CityQuery;
import com.zysl.cloud.pms.service.ICityService;
import com.zysl.cloud.pms.common.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/29 15:53
 */
@Service
public class CityServiceImpl implements ICityService {

    //@Autowired
    private CitySlaveMapper citySlaveMapper;

    @Override
    public List<CityBO> queryCityInfoByName(CityQuery cityQuery) {
        return null;
    }

    @Override
    public CityBO queryCityInfoById(CityQuery cityQuery) {
        City copy = BeanCopyUtil.copy(cityQuery, City.class);
        if (copy == null) {
            return null;
        }
        return BeanCopyUtil.copy(citySlaveMapper.selectOne(copy),CityBO.class);
    }
}
