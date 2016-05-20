package com.jim.service.impl;

import com.jim.service.UserService;
import com.jim.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jim on 2016/5/20.
 * This class is ...
 */
@Service
public class UserServiceImpl implements UserService {
	@Override
	public long create(User user) {
		return 0;
	}

	@Override
	public User read(long id) {
		return null;
	}

	@Override
	public int update(long id, User user) {
		return 0;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

	@Override
	public List<User> all() {
		return null;
	}
}
