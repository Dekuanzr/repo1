package com.dekuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController     //组合键：@Controller+@ResponseBody的使用
@RequestMapping("/restful")     //获取restful编程风格中url里面占位符的值
public class RestfulController {

    //根据id查询
    //@ResponseBody     直接数据响应
    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/user/{id}")   //相当于@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable Integer id) {  //用来接收占位符
        //调用service方法对id=2这条记录的查询
        return "findById:"+id;
    }

    //添加
    @PostMapping("/user")
    public String post(){
        return "post";
    }

    //更新
    @PutMapping("/user")
    public String put() {
        return "put";
    }
    //删除
    @DeleteMapping(value = "/user/{id}")
    public String delete(@PathVariable Integer id) {
        return "delete:"+id;
    }
}
