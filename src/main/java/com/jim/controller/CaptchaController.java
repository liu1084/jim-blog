package com.jim.controller;

import com.jim.model.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Jim on 2016/5/18.
 * This class is ...
 */
@RestController
public class CaptchaController {
	@Autowired
	CaptchaService captchaService;

	@RequestMapping(value = {"/captcha"}, method = RequestMethod.GET)
	public String captcha() throws IOException {
		captchaService.generateImage();
		return captchaService.getFile();
	}
}
