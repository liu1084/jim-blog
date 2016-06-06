package com.jim.controller;


import com.jim.model.User;
import com.jim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
    public List<User> index() {
        return userService.all();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int update(@RequestBody(required = true) User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public long create(@RequestBody(required = true) User user) {
        return userService.create(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User read(@PathVariable(value = "{id}") long id) {
        return userService.read(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable(value = "{id}") long id) {
        return userService.delete(id);
    }


}
