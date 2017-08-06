package my.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class HelloController {
    
    @Value("${key1}")
    private String a;
    
    @Autowired
    private MyService myService;
    
    @Autowired
    private MyTest myTest;

    @RequestMapping("hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }

}
