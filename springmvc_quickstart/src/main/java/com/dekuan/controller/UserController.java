package com.dekuan.controller;

import com.dekuan.domain.QueryVo;
import com.dekuan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")    //一级访问目录
@SessionAttributes("username")  //将request域(model)中的username的值存入数据中并同步到session中
public class UserController {

    /*
    path和value的作用是一样的
    method请求方式get/post
    请求时限制携带的参数

    return "success";
    实际上是一次请求转发且地址栏不会进行改变
    */
    @RequestMapping(path = "/quick",method = RequestMethod.GET,params = {"accountName"})
    public String quick() {
        //业务逻辑处理
        System.out.println("SpringMVC入门");
        //视图跳转
        //逻辑地址
        return "success";
    }
    /*
        获取基本数据类型请求参数
     */
//    @RequestMapping("/simpleParam")
    @RequestMapping("/requestParam")
    public String requestParam(Integer id,String userName) {

        System.out.println(id);
        System.out.println(userName);
        return "success";
    }
    /*
        获取对象类型的请求参数
     */
    @RequestMapping("/pojoParam")
    public String pojoParam(Integer id,String userName) {
        System.out.println(id);
        System.out.println(userName);
        return "success";
    }
    /*
        获取数组类型的请求参数
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }
    /*
        获取复杂数据类型的请求参数
     */
    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo) {
        System.out.println(queryVo);
        return "success";
    }
    /*
        获取时间类型的请求参数(自定义类型转换)
     */
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println(birthday);
        return "success";
    }
    /*
        @RequestParam注解的演示
            name:匹配页面传递参数的名称
            defaultValue:设置的默认值
            required:是否必须传递参数，默认是(true)
                     如果设置了默认值，则改为true
     */
    @RequestMapping("/findByPage")
    public String findByPage(@RequestParam(name = "pageNo",defaultValue = "1",required = false) Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(pageNum);    //2
        System.out.println(pageSize);       //5
        return "success";
    }
    /*
        @RequestHeader的使用
            获取请求头的数据
     */
    @RequestMapping("/requestHead")
    public String requestHead(@RequestHeader("cookie") String cookie) {
        System.out.println(cookie);
        return "success";
    }
    /*
        @CookieValue
            获取cookie中的数据
     */
    @RequestMapping("/cookieValue")
    public String cookieValue( @CookieValue("JSESSIONID")String jSessionId){
        System.out.println(jSessionId);
        return "success";
    }
    /*
        原始ServletAPI的获取
     */
    @RequestMapping("/servletAPI")
    public String  servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }
    /*
        使用原始ServletAPI进行页面跳转
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //直接返回字符串数据
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("李晓");

        //借助request对象完后请求转发：一次请求(服务器内部请求，可以进行安全目录的访问)
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //借助response对象进行重定向:重定向是两次请求：WEB-INF是安全目录，不允许外部请求直接访问，只允许服务器内部访问
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    /*
        演示forward关键字进行请求转发:一次请求
     */
    @RequestMapping("/forward")
    public String forward(Model model) {

        //在模型中设置一些值
        model.addAttribute("username","lx");

        //请求转发时不仅可以转发jsp的内容，还可以转发其他控制器方法
//        return "forward:/product/findAll";
        return "forward:/WEB-INF/pages/success.jsp";
    }

    /*
        @SessionAttributes的使用
     */
    @RequestMapping("/returnString")
    public String returnString() {
        return "success";
    }
    /*
        使用redirect关键字进行重定向：两次请求
     */
    @RequestMapping("redirect")
    public String redirect(Model model) {
        //底层实现的是request.setAttribute("username","lx")域的范围：一次请求(显示不出来)
        model.addAttribute("username","lx");
        return "redirect:/index.jsp";
    }
    /*
        ModelAndView的使用
     */
    //方式一
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        /*
            model模型：用于封装存储数据
            view视图：用于展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //模型数据
        modelAndView.addObject("username","李晓");
        //视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }
    //方式二
    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(ModelAndView modelAndView2){
          /*
            model模型：用于封装存储数据
            view视图：用于展示数据
         */
        //模型数据
        modelAndView2.addObject("username","李晓");
        //视图名称
        modelAndView2.setViewName("success");
        return modelAndView2;
    }

    /*
        ajax交互
        @RequestBody:将json串封装成一个集合或者一个对象
        @ResponseBody：响应时将集合转换为json字符串响应给客户端
     */
    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list) {
        System.out.println(list);
        return list;
    }
}

