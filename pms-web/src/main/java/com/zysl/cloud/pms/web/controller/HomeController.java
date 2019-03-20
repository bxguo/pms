package com.zysl.cloud.pms.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: bxguo
 * @time: 2019/3/19 17:44
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String hello(){
        String str = "hello:" + new Date();
        System.out.println(str);
        return str;
    }
}
