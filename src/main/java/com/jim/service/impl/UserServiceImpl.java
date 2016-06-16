package com.jim.service.impl;

import com.jim.mapper.UserMapper;
import com.jim.service.UserService;
import com.jim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jim on 2016/5/20.
 * This class is ...
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long create(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User read(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int delete(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> users() {
        return userMapper.users();
    }
}
