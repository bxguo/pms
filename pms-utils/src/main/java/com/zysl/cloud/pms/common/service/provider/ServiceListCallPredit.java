package com.zysl.cloud.pms.common.service.provider;

import com.zysl.cloud.pms.common.constants.MyPage;

import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/3/28 17:11
 */
@FunctionalInterface
public interface ServiceListCallPredit<P, R> {
    List<R> solve(P req, MyPage page);
}
