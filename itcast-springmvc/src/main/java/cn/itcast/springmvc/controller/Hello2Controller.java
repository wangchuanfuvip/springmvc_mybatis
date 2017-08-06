package cn.itcast.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/hello2")
@Controller
// 标识一个普通的类成为SpringMVC的Handler
public class Hello2Controller {

    @RequestMapping("/show")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "我的第一个注解Controller测试！");
        return mv;
    }
    
    @RequestMapping("/show2")
    public ModelAndView show2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "我的第二个注解Controller测试！");
        return mv;
    }

}
