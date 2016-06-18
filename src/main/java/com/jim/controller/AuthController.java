package com.jim.controller;

import com.jim.common.BlogBase;
import com.jim.model.LoginEntry;
import com.jim.model.User;
import com.jim.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by liqing on 2016/6/17.
 */
public class AuthController implements BlogBase {
    @Autowired
    AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginEntry loginEntry){
        return authService.login(loginEntry);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user){
        return authService.register(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession httpSession){
        return "";
    }
}
