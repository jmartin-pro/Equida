package com.equida.rest.api.config;

import java.util.EnumSet;
import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements ServletContextInitializer, WebMvcConfigurer {

    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
    }
}
