package cn.itcast.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UserForm;

@RequestMapping(value = "/demo")
@Controller
public class DemoController {
    
    /**
     * 测试Ant风格多字符映射
     */
    @RequestMapping(value = "/show1/*/test")
    public ModelAndView show1() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show1方法!");
        return mv;
    }

    /**
     * 测试Ant风格多目录映射
     */
    @RequestMapping(value = "/show2/**/test")
    public ModelAndView show2() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show2方法!");
        return mv;
    }

    /**
     * 占位符url映射
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/show3/{id}/{name}")
    public ModelAndView show3(@PathVariable("id") Long id, @PathVariable("name") String name) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show3  aabb方法! id = " + id + ", name = " + name);
        return mv;
    }

    /**
     * 占位符url映射
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/show4/{id}")
    public ModelAndView show4(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show4方法! id = " + id);
        return mv;
    }

    /**
     * 测试限制请求方法
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/show6", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView show6() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show6方法! 你的请求方法为 :POST");
        return mv;
    }

    /**
     * 限制请求参数 demo/show7.do?id=123
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/show7", params = "id")
    public ModelAndView show7(@RequestParam("id") Long id) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show7方法! id = " + id);
        return mv;
    }

    /**
     * 获取Servlet的内置对象
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/show8")
    public ModelAndView show8(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView("test-servlet");
        StringBuilder sb = new StringBuilder();
        sb.append("HttpServletRequest: " + request + "<br/>");
        sb.append("HttpServletResponse: " + response + "<br/>");
        sb.append("HttpSession: " + session + "<br/>");
        mv.addObject("msg", sb.toString());
        request.setAttribute("mydata", "request对象中的数据!");
        return mv;
    }

    /**
     * @RequestParam
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/show9")
    public ModelAndView show9(@RequestParam(value = "id", required = true, defaultValue = "0") Long id) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show9方法! id = " + id);
        return mv;
    }

    /**
     * 获取cookie
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/show10")
    public ModelAndView show10(@CookieValue("JSESSIONID") String JSESSIONID) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "当前访问的是DemoController中的show10方法! JSESSIONID = " + JSESSIONID);
        return mv;
    }

    /**
     * 绑定pojo对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/show11")
    public ModelAndView show11(User user) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "user = " + user);
        return mv;
    }

    /**
     * 测试表单提交，基本数据类型的绑定
     * 
     * @param name
     * @param age
     * @param income
     * @param isMarried
     * @param interests
     */
    @RequestMapping("/show12")
    @ResponseStatus(value = HttpStatus.OK)
    // 无需跳转页面，直接返回200状态
    public void demo12(String name, Integer age, Double income, Boolean isMarried, String[] interests) {
        System.out.println("简单数据类型绑定=========");
        System.out.println("名字:" + name);
        System.out.println("年龄:" + age);
        System.out.println("收入:" + income);
        System.out.println("已结婚:" + isMarried);
        System.out.println("兴趣:");
        for (String interest : interests) {
            System.out.println(interest);
        }
        System.out.println("====================");
    }

    @RequestMapping("/show13")
    public ModelAndView demo13(UserForm userForm) {
        List<User> users = userForm.getUsers();
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user);
            sb.append(" | ");
        }
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", sb.toString());
        return mv;

    }

    /**
     * 测试jstl标签
     * 
     * @return
     */
    @RequestMapping("/demo14")
    public ModelAndView demo14() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setCreated(new Date());
            user.setId(Long.valueOf(i));
            user.setName("name_" + i);
            user.setPassword("123456");
            user.setSex(true);
            user.setUpdated(user.getCreated());
            user.setUserName("userName_" + i);
            users.add(user);
        }
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    /**
     * 返回json视图
     * 
     * @return
     */
    @RequestMapping("/demo15")
    @ResponseBody
    public List<User> demo15() {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setCreated(new Date());
            user.setId(Long.valueOf(i));
            user.setName("name_" + i);
            user.setPassword("123456");
            user.setSex(true);
            user.setUpdated(user.getCreated());
            user.setUserName("userName_" + i);
            users.add(user);
        }
        return users;
    }
    
    /**
     * 测试 @RequestBody
     * @param user
     * @return
     */
    @RequestMapping(value = "/show16")
    public ModelAndView show16(@RequestBody User user) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "user = " + user);
        return mv;
    } 

}
