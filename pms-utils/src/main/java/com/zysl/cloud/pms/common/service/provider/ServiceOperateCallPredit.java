package com.zysl.cloud.pms.common.service.provider;

/**
 * @author: bxguo
 * @time: 2019/3/28 17:11
 */
@FunctionalInterface
public interface ServiceOperateCallPredit<P, R> {
    R solve(P req);
}
