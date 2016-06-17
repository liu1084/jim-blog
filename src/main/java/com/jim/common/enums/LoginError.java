package com.jim.common.enums;

import com.google.gson.JsonElement;
import com.jim.common.Type;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
@Service
public enum LoginError implements Type {

	@Value("#{auth.login.error.usernameNotExist}")
	USERNAME_NOT_EXIST,

	@Value("#{auth.login.error.passwordError}")
	USERNAME_OR_PASSWORD_ERROR,

	@Value("#{auth.login.error.userIsNotActive}")
	USERNAME_IS_NOT_ACTIVE;


	@Override
	public String info() {
		return this.tip;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	private String tip;
}
