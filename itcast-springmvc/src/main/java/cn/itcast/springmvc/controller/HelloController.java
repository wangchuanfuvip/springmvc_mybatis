package cn.itcast.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        //设置视图名称
        mv.setViewName("hello");
        //设置模型数据
        mv.addObject("msg", "我的第一个SpringMVC程序!");
        //返回ModelAndView对象
        return mv;
    }

}
