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
