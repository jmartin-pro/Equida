package com.equida.rest.config;

import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements ServletContextInitializer, WebMvcConfigurer {

    @Override
    public void onStartup(ServletContext servletContext) {
    }
}
