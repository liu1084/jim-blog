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

package com.jim.controller;

import com.jim.common.BlogBase;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liqing on 2016/6/5.
 */

@Controller
public class BlogErrorController implements BlogBase, ErrorController {

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception.getMessage());
		modelAndView.addObject("url", httpServletRequest.getRequestURL());
		modelAndView.addObject("code", httpServletResponse.getStatus());
		modelAndView.setViewName("/commons/error");
		return modelAndView;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
