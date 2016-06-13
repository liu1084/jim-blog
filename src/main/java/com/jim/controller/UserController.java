package com.jim.controller;


import com.jim.model.User;
import com.jim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
    @ResponseBody
    public List<User> index() {
        return userService.all();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public int update(@RequestBody(required = true) User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public long create(@RequestBody(required = true) User user) {
        return userService.create(user);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User read(@PathVariable long id) {
        return userService.read(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(@PathVariable(value = "{id}") long id) {
        return userService.delete(id);
    }


}
