package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.util.AuthTokenFilter;


@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/api/**")
						.hasRole("USER")
					.antMatchers("/**")
						.hasRole("ADMIN")
						  .and()
							.csrf().disable().headers()
								.frameOptions().disable();
		/*
		 * .and() .logout() .invalidateHttpSession(true) .deleteCookies("JSESSIONID");
		 * 
		 * http.addFilterBefore(new AuthTokenFilter(userDetailsService),
		 * BasicAuthenticationFilter.class);
		 */

	}
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
		NoOpPasswordEncoder.getInstance());
		  //auth.inMemoryAuthentication().passwordEncoder(
		  //NoOpPasswordEncoder.getInstance())
		  //.withUser("user").password("123").roles("USER");
	}
	
}


