package com.dekuan.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/stringMVCTest")
    public String stringMVCTest() {

        int i=1/0;

        return "success";
    }
}
