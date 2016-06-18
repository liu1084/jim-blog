package com.jim.service.impl;

import com.jim.mapper.UserMapper;
import com.jim.model.LoginEntry;
import com.jim.model.User;
import com.jim.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authority
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    /**
     * Login
     * @param loginEntry
     * @return
     */
    @Override
    public String login(LoginEntry loginEntry) {

        return "";
    }

    /**
     * Logout
     * @param id
     * @return
     */
    @Override
    public String logout(long id) {

        return null;
    }

    /**
     * regist a new user
     * @param user
     * @return
     */
    @Override
    public String register(User user) {

        return null;
    }

    /**
     * Reset a user's password by sending a mail
     * @param username
     * @return
     */
    @Override
    public String resetPassword(String username) {
        return null;
    }
}
