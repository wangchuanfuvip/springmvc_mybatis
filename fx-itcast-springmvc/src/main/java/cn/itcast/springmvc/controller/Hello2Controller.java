package cn.itcast.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/hello")
@Controller
public class Hello2Controller {
    
    @RequestMapping("/show")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "我的第一个复习注解SpringMVC程序!");
        return mv;
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.POST,params="!id")
    public ModelAndView test(@PathVariable("id")String id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "我的第一个复习注解SpringMVC程序!");
        return mv;
    }
    
    @RequestMapping(value = "/test3")
    public ModelAndView test3(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "request = " + request);
        return mv;
    }
    
    @RequestMapping(value = "/test4")
    public ModelAndView test3(@RequestParam("id")Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "id = " + id);
        return mv;
    }
    
    @RequestMapping(value = "/test5")
    @ResponseBody
    public List<Map<String, Object>> test5(){
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "张三");
        list.add(map);
        
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("name", "李四");
        list.add(map2);
        return list;
    }

}
