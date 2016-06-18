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

package com.jim.service.impl;

import com.jim.mapper.UserMapper;
import com.jim.mapper.UserRoleMapper;
import com.jim.model.Role;
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

    @Autowired
    private UserRoleMapper userRoleMapper;

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

    @Override
    public List<Role> getRoles(long id) {
        return userRoleMapper.getRoles(id);
    }

    @Override
    public void addRoles(long userId, List<Role> roles) {
        for (Role role : roles) {
            userRoleMapper.addRole(userId, role.getId());
        }
    }

    @Override
    public void deleteRoles(long userId, List<Role> roles) {
        for (Role role : roles) {
            userRoleMapper.deleteRole(userId, role.getId());
        }
    }

}
