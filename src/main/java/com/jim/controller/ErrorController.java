package com.jim.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by liqing on 2016/6/5.
 */

@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorController {

	@RequestMapping(value = {"", "/"})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String error(String code){
		return "commons/404";
	}
}
