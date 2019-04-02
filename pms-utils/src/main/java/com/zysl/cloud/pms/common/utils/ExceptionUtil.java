package com.zysl.common.utils;

/**
 * @author: bxguo
 * @time: 2019/4/2 15:08
 */
public class ExceptionUtil {

    private ExceptionUtil(){}

    public static RuntimeException unchecked(Exception e){
        if (e instanceof RuntimeException){
            return (RuntimeException) e;
        }
        return new RuntimeException();
    }

}
