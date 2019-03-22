package com.example;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bootdemo
 * @description: 检查项目启动
 * @author: linxiaojiu
 * @create: 2018/8/28
 **/
@RestController
public class CheckController {

    @RequestMapping("/check")
    public String check(String str){
        if(StringUtils.isEmpty(str)){
            return "check";
        }

        return str;
    }
}
