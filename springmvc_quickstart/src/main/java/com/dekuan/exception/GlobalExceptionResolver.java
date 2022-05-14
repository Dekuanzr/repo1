package com.dekuan.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /*
        实际抛出的异常
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //当出现异常后，跳转到最终的异常信息页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
