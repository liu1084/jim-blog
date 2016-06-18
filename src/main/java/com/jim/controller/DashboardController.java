package com.jim.controller;

import com.jim.common.BlogBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Render home page
 */
@Controller
public class DashboardController implements BlogBase {
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
