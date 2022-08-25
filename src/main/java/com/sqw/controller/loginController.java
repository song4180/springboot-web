package com.sqw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @RequestMapping("/user/login")
    //@ResponseBody//测试方法能否进入, 将返回值以json返回前端
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //System.out.println(username+",,,,"+password);
        if(!StringUtils.isEmpty(username)&&"222".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码错误！！！！");
            return "index";
        }
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
