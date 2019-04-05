package com.equida.webapp.web.interceptor;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		request.setAttribute(InputOutputAttribute.USER, getAuthentificatedUser());
		
        return true;
    }

	@Override
	public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
		AuthentificatedUser user = getAuthentificatedUser();
		
		if(user != null && mav != null)
			mav.addObject(InputOutputAttribute.USER, user);
	}
	
	private AuthentificatedUser getAuthentificatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof UsernamePasswordAuthenticationToken)
			return (authentication.getPrincipal() instanceof AuthentificatedUser) ? (AuthentificatedUser) authentication.getPrincipal() : null;
		
		return null;
	}
}
