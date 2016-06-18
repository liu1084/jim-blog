/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Jim Liu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
