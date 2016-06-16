package com.jim.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liqing on 2016/6/5.
 */

@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class BlogErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return null;
	}
}
