package com.equida.webapp.web.config;

import com.equida.webapp.web.interceptor.UserInterceptor;
import java.util.EnumSet;
import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements ServletContextInitializer, WebMvcConfigurer {

	@Autowired
	private UserInterceptor apporteurInterceptor;
	
    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
    }
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addViewController("/login").setViewName("login");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apporteurInterceptor);
	}
}
