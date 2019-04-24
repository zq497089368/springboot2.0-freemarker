package com.zq.controller;

import com.zq.entity.UserPO;
import com.zq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public UserPO getUser(){
        return userService.findById(1L);
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request){
        request.setAttribute("user", userService.findById(1L));
        return "showUser";
    }

    @RequestMapping("/addUser")
    public String addUser(UserPO userPO){
        userService.save(userPO);
        return "success4";
    }
}
