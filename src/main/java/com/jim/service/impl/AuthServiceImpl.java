package com.jim.service.impl;

import com.google.gson.JsonObject;
import com.jim.common.enums.LoginError;
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
		LoginError tip = null;
		boolean isLogin = false;

		String username = loginEntry.getUsername();
		String password = loginEntry.getPassword();
		String challengeCode = loginEntry.getChallengeCode();
		JsonObject jsonObject = new JsonObject();

		int count = userMapper.getCountByUsername(username);
		if (count == 0){
			tip = LoginError.USERNAME_NOT_EXIST;
		}

		User user = userMapper.getUserByUsername(username);
		if (user == null || !user.getPassword().equals(loginEntry.getPassword())){
			tip = LoginError.USERNAME_OR_PASSWORD_ERROR;
		}

		if (user != null && user.getIsactive().equals("0")){
			tip = LoginError.USERNAME_IS_NOT_ACTIVE;
		}

		if (!tip.equals("")){
			jsonObject.addProperty("isLogin", isLogin);
			//jsonObject.add("tip", tip);
		}

		return jsonObject.toString();
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
