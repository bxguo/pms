package com.zysl.cloud.pms.share;


import com.alibaba.fastjson.JSON;

/**
 * @author: bxguo
 * @time: 2019/3/28 17:55
 */
public class BeanCopyUtil {
    private BeanCopyUtil() {
    }

    public static <F,T>T copy(F from, Class<T> destCls){
        if (from == null) {
            return null;
        }

        if (from.getClass().equals(destCls)) {
            return (T) from;
        }
        return JSON.parseObject(JSON.toJSONString(from), destCls);
    }
}
