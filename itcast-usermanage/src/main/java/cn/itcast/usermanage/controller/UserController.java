package cn.itcast.usermanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;
import cn.itcast.usermanage.vo.EasyUIResult;
import cn.itcast.usermanage.vo.MyResult;

@RequestMapping("/user")
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryUserList(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        return this.userService.queryUserList(page,rows);
    }
    
    /**
     * 新增用户
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public MyResult saveUser(User user){
        try {
            this.userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResult(500, "保存失败!");
        }
        return MyResult.ok();
    }
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public MyResult updateUser(User user){
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResult(500, "保存失败!");
        }
        return MyResult.ok();
    }
    
    /**
     * 导出Excel
     * 
     * @return
     */
    @RequestMapping(value = "/export")
    public ModelAndView export(){
        ModelAndView mv = new ModelAndView();
        List<User> users = this.userService.queryAll();
        mv.setViewName("excelView");
        mv.addObject("userList", users);//在视图中使用模型数据
        return mv;
    }

}
