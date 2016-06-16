package com.jim.controller;

import com.jim.common.BlogBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */
@Controller
@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
public class DashboardController implements BlogBase {
	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
