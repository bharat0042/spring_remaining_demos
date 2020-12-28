package com.bharat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("ben").password("ben123").roles("USER"));
		auth.inMemoryAuthentication().withUser(users.username("ken").password("ken123").roles("USER", "ADMIN"));
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {  
    	http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/customers/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/v1/customers/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/v1/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/customers/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
