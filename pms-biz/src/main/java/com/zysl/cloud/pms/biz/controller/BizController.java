package com.zysl.cloud.pms.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: bxguo
 * @time: 2019/3/19 17:44
 */
@RestController
public class BizController {
    @GetMapping("/")
    public String hello(){
        String str = "BizHello:" + new Date();
        System.out.println(str);
        return str;
    }
}
