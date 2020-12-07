package com.ad4ayb.semtaskad4ayb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
    	 registry.addViewController("/index").setViewName("index");
         registry.addViewController("/").setViewName("index");
         registry.addViewController("/all").setViewName("all");
         registry.addViewController("/update").setViewName("update");
         registry.addViewController("/new").setViewName("new");
         registry.addViewController("/success").setViewName("success");
         registry.addViewController("/login").setViewName("login");
         registry.addViewController("/logout").setViewName("login");
    }
}