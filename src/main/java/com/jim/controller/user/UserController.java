package com.jim.controller.user;


import com.jim.model.User;
import com.jim.service.UserService;
import com.jim.service.impl.UserServiceImpl;
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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<User> all = userService.all();
        model.addAllAttributes(all);
        return "index";
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public int update(@PathVariable(value = "id") long id, @RequestBody(required = true) User user) {
        return 0;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public long create(@RequestBody(required = true) User user) {
        return 0L;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User read(@PathVariable(value = "{id}") long id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable(value = "{id}") long id) {
        return false;
    }


}
