package com.jim.controller.user;


import com.jim.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		return null;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
	public int update(@PathVariable (value = "id") long id, @RequestBody(required = true) User user){
		return 0;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public long create(@RequestBody(required = true) User user){
		return 0L;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User read(@PathVariable (value = "{id}") long id){
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable (value = "{id}") long id){
		return false;
	}


}
