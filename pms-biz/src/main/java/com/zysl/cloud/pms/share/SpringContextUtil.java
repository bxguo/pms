package com.zysl.cloud.pms.share;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: bxguo
 * @time: 2019/3/29 9:08
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType){
        return applicationContext.getBean(requiredType);
    }
    public static <T> T getBean(String name, Class<T> requiredType){
        return applicationContext.getBean(name, requiredType);
    }
}