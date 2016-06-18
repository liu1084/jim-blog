package com.jim.service.impl;

import com.jim.mapper.UserMapper;
import com.jim.model.LoginEntry;
import com.jim.model.User;
import com.jim.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(LoginEntry loginEntry) {

        return "";
    }

    @Override
    public String logout(long id) {

        return null;
    }

    @Override
    public String register(User user) {

        return null;
    }

    @Override
    public String resetPassword(String username) {
        return null;
    }
}
