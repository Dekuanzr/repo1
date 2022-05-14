package com.dekuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class targetController {

    @RequestMapping("target")
    public String targetMethod() {

        System.out.println("目标方法执行了...");

        return "success";
    }
}
