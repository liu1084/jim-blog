package com.jim.controller;

import com.jim.common.BlogBase;
import com.jim.model.LoginEntry;
import com.jim.model.User;
import com.jim.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


public class AuthController implements BlogBase {
    @Autowired
    AuthService authService;

    /**
     * Login by username,password & challenger code
     * @param loginEntry
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginEntry loginEntry){
        return authService.login(loginEntry);
    }

    /**
     * Register a new user
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user){
        return authService.register(user);
    }

    /**
     * Logout
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession httpSession){
        return "";
    }
}
