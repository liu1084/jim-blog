package com.jim.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jim on 2016/5/19.
 * This class is ...
 */
@Controller
@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
public class DashboardController {
    @RequestMapping(value = {"", "/index.html"}, method = RequestMethod.GET)
    public String index() throws IOException {
//        ClassPathResource classPathResource = new ClassPathResource("static/app/css/ie.css");
//
//
//        InputStream inputStream = classPathResource.getInputStream();
//        try {
//            File somethingFile = File.createTempFile("test", ".txt");
//            FileUtils.copyInputStreamToFile(inputStream, somethingFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(inputStream);
//        }

        return "index";
    }

    @RequestMapping(value = {"/hub.html"}, method = RequestMethod.GET)
    public String hub(){
        return "hub";
    }
}
