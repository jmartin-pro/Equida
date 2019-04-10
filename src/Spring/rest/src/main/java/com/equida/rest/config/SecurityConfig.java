package com.equida.rest.config;

import com.equida.common.utils.Sha256PasswordEncoder;
import com.equida.common.authentification.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	private AuthentificationService authentificationService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated()
			.and().httpBasic().authenticationEntryPoint(authEntryPoint)
			.and().cors()
			.and().csrf().disable();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(authentificationService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new Sha256PasswordEncoder();
	}
	
	//https://stackoverflow.com/questions/36968963/how-to-configure-cors-in-a-spring-boot-spring-security-application
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.applyPermitDefaultValues();
		corsConfiguration.addAllowedMethod(HttpMethod.GET);
		corsConfiguration.addAllowedMethod(HttpMethod.POST);
		corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
		corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
