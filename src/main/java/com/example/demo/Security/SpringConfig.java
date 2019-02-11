package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
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
								/*.and()
								  .logout() 
								  .invalidateHttpSession(true)
								  .deleteCookies("JSESSIONID");*/
	}

	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
		NoOpPasswordEncoder.getInstance());
		  //auth.inMemoryAuthentication().passwordEncoder(
				  //NoOpPasswordEncoder.getInstance())
		  //.withUser("user").password("123").roles("USER");
	}
	
	/*
	 * @Override
	 * 
	 * @Bean public UserDetailsService userDetailsServiceBean() { return
	 * userDetailsService; }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder registry)
	 * throws Exception { registry.userDetailsService(userDetailsServiceBean()); }
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 * 
	 * @Bean public DigestAuthenticationEntryPoint digestEntryPoint() {
	 * DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new
	 * DigestAuthenticationEntryPoint();
	 * digestAuthenticationEntryPoint.setKey("acegi");
	 * digestAuthenticationEntryPoint.setRealmName("Digest Realm");
	 * digestAuthenticationEntryPoint.setNonceValiditySeconds(10); return
	 * digestAuthenticationEntryPoint; }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .exceptionHandling() .authenticationEntryPoint(digestEntryPoint()) .and()
	 * .addFilterAfter(digestAuthenticationFilter(digestEntryPoint()),
	 * BasicAuthenticationFilter.class) .antMatcher("/api/**") .csrf() .disable()
	 * .authorizeRequests() .anyRequest() .authenticated() .and() .formLogin()
	 * .permitAll() .and() .logout() .deleteCookies("remove")
	 * .invalidateHttpSession(true) .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")) .logoutSuccessUrl("/login") .permitAll(); }
	 * 
	 * 
	 * 
	 * @Bean public DigestAuthenticationFilter digestAuthenticationFilter(
	 * DigestAuthenticationEntryPoint digestAuthenticationEntryPoint) {
	 * DigestAuthenticationFilter digestAuthenticationFilter = new
	 * DigestAuthenticationFilter();
	 * digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
	 * digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
	 * return digestAuthenticationFilter; }
	 */
}


