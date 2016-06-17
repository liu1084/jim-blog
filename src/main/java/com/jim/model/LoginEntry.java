package com.jim.model;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
public class LoginEntry {
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getChallengeCode() {
		return challengeCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setChallengeCode(String challengeCode) {
		this.challengeCode = challengeCode;
	}

	private String username;
	private String password;
	private String challengeCode;
}
