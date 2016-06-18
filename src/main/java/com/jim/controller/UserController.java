package com.jim.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jim.model.Role;
import com.jim.model.User;
import com.jim.service.UserService;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
	@Autowired
	UserService userService;

    /**
     * Get all users
     * @return
     */
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public List<User> index() {
		return userService.users();
	}

    /**
     * Update a user
     * @param user
     * @return
     */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public int update(@RequestBody(required = true) User user) {
		return userService.update(user);
	}

    /**
     * Create a new user
     * @param user
     * @return
     */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public long create(@RequestBody(required = true) User user) {
		return userService.create(user);
	}

    /**
     * Get a user by id
     * @param id
     * @return
     */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User read(@PathVariable long id) {
		return userService.read(id);
	}

    /**
     * Delete a user by id
     * @param id
     * @return
     */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int delete(@PathVariable long id) {
		return userService.delete(id);
	}

	@RequestMapping(value = "/{id}/roles", method = RequestMethod.GET)
	public List<Role> getRoles(@PathVariable long id){
		return userService.getRoles(id);
	}


    /**
     * Get all roles of a user by user id
     * @param id
     * @param roles
     */
    @RequestMapping(value = "/{id}/roles", method = RequestMethod.POST)
    public void addRoles(@PathVariable long id, List<Role> roles){
        userService.addRoles(id, roles);
    }

    /**
     * Delete roles of a user by user id & role list
     * @param id
     * @param roles
     */
    @RequestMapping(value = "/{id}/roles", method = RequestMethod.DELETE)
    public void deleteRoles(@PathVariable long id, List<Role> roles){
        userService.deleteRoles(id, roles);
    }
}
