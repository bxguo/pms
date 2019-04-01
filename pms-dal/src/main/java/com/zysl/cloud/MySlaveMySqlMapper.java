package com.zysl.cloud;

import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.condition.SelectByConditionMapper;
import tk.mybatis.mapper.common.condition.SelectCountByConditionMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * @author: bxguo
 * @time: 2019/3/29 16:47
 */
public interface MySlaveMySqlMapper<T> extends BaseSelectMapper<T>, SelectOneByExampleMapper<T>,
        SelectCountByExampleMapper<T>, RowBoundsMapper<T>, SelectByIdsMapper<T>, SelectByConditionMapper,
        SelectCountByConditionMapper {

}
