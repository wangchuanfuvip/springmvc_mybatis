package com.taotao.sso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.vo.TaotaoResult;
import com.taotao.sso.pojo.User;
import com.taotao.sso.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 检测数据是否可用
     * 
     * @param param 用户输入的参数
     * @param type type为类型，可选参数1、2、3分别代表username、phone、email
     * @return
     */
    @RequestMapping(value = "check/{param}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult check(@PathVariable("param") String param, @PathVariable("type") Integer type) {
        return this.userService.check(param, type);
    }

    /**
     * 用户注册
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult register(@Valid User user, BindingResult result) {
        // 对数据合法性校验
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            List<String> myErrors = new ArrayList<String>();
            for (ObjectError objectError : errors) {
                myErrors.add(objectError.getDefaultMessage());
            }
            return TaotaoResult.build(202, StringUtils.join(myErrors, '|'));
        }

        // 通过md5算法对密码加密
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        boolean boo = this.userService.register(user);
        if (boo) {
            return TaotaoResult.ok();
        }
        return TaotaoResult.build(201, "注册失败!");
    }

    /**
     * 登录
     * 
     * @param userName
     * @param passwd
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(@RequestParam("u") String userName, @RequestParam("p") String passwd) {
        // 返回
        String ticket = this.userService.login(userName, passwd);
        if (ticket == null) {
            return TaotaoResult.build(201, "用户名、密码错误, 登录失败！");
        }
        return TaotaoResult.ok(ticket);
    }

    /**
     * 登录
     * 
     * @param userName
     * @param passwd
     * @return
     */
    @RequestMapping(value = "query/{ticket}", method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult login(@PathVariable("ticket") String ticket) {
        // 返回
        String userJson = null;
        try {
            userJson = this.userService.queryUserByTicket(ticket);
            if (userJson == null) {
                return TaotaoResult.build(201, "查询失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(201, "查询失败！");
        }
        return TaotaoResult.ok(userJson);
    }

}
