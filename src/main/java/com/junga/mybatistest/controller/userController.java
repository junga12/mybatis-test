package com.junga.mybatistest.controller;

import com.junga.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("msg", "World!");
        return "/index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showUsers(Model model) throws Exception {
        model.addAttribute("users", userService.getAllUser());
        return "/showUser";
    }
}
