package com.zysl.cloud.pms.dal.dao.pms.mysql;


import com.zysl.cloud.MySlaveMySqlMapper;
import com.zysl.cloud.pms.domain.pg.pms.pms.City;
import org.springframework.stereotype.Component;

@Component
public interface CitySlaveMapper extends MySlaveMySqlMapper<City> {

}