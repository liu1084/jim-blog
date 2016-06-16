package com.jim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ImportResource({"blog.xml"})
@PropertySource(value = "application.properties")
@MapperScan("com.jim.mapper")
public class BlogApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
