package com.jim.service;

import com.jim.model.LoginEntry;
import com.jim.model.User;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
public interface AuthService {
	String login(LoginEntry loginEntry);
	String logout(long id);
	String register(User user);
	String resetPassword(String username);
}
