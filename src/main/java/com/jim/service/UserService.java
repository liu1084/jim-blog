package com.jim.service;

import com.jim.model.User;

import java.util.List;

/**
 * Created by Jim on 2016/5/20.
 * This class is ...
 */
public interface UserService {
	long create(User user);
	User read(long id);
	int update(long id, User user);
	boolean delete(long id);
	List<User> all();
}
