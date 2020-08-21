package com.cmr.shirodemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2020/8/21 15:11
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/toLogin").setViewName("login");
        registry.addViewController("/user/noAuth").setViewName("noAuth");
        registry.addViewController("/user/toAdd").setViewName("user/add");
        registry.addViewController("/user/toUpdate").setViewName("user/update");
        registry.addViewController("/user/toIndex").setViewName("index");
    }

}
