package com.equida.rest.api.controller.login;

import com.equida.common.authentification.AuthentificatedUser;
import com.equida.rest.api.dto.filter.BasicFilterDto;
import com.equida.rest.api.dto.RoleDto;
import com.equida.rest.api.route.login.LoginApiRoute;
import javax.validation.Valid;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
	
	@GetMapping(LoginApiRoute.RAW_URI)
	public RoleDto get(@Valid BasicFilterDto filterDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof UsernamePasswordAuthenticationToken) {
			if(authentication.getPrincipal() instanceof AuthentificatedUser)  {
				AuthentificatedUser user = (AuthentificatedUser) authentication.getPrincipal();
				
				return RoleDto.convertToDto(user.getCompte().getRole());

			}

		}
		
		return null;
		
	}

}
