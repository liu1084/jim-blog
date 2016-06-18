package com.jim.controller;


import com.jim.model.LoginEntry;
import com.jim.model.Role;
import com.jim.model.User;
import com.jim.service.AuthService;
import com.jim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

	@RequestMapping(value = {"", "/", "/users"}, method = RequestMethod.GET)
	public List<User> index() {
		return userService.users();
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public int update(@RequestBody(required = true) User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public long create(@RequestBody(required = true) User user) {
		return userService.create(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User read(@PathVariable long id) {
		return userService.read(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int delete(@PathVariable long id) {
		return userService.delete(id);
	}

	@RequestMapping(value = "/{id}/roles", method = RequestMethod.GET)
	public List<Role> getRoles(@PathVariable long id){
		return userService.getRoles(id);
	}


    @RequestMapping(value = "/{id}/roles", method = RequestMethod.POST)
    public void addRoles(@PathVariable long id, List<Role> roles){
        userService.addRoles(id, roles);
    }

    @RequestMapping(value = "/{id}/roles", method = RequestMethod.DELETE)
    public void deleteRoles(@PathVariable long id, List<Role> roles){
        userService.deleteRoles(id, roles);
    }
}
