package com.jim.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jim.liu on 2016-06-15.
 * This class is ...
 */
@Configuration
public class CORSConfig {
	@Bean
	public WebMvcConfigurer CORSConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				super.addCorsMappings(registry);
				registry.addMapping("/**")
						.allowedHeaders("*")
						.allowedOrigins("*")
						.allowedMethods("*")
						.maxAge(3600);
			}
		};
	}
}
