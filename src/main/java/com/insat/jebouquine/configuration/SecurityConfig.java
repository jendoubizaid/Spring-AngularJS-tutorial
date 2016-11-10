package com.insat.jebouquine.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMethod;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select login as principal, passwd as credentials,true from user where login=?")
		.authoritiesByUsernameQuery("select User_login as principal,roles_role as role from user_role where User_login=?")
		.rolePrefix("ROLE_");
		auth
		.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/css/**","/js/**","/images/**").permitAll()
			.and()
		.authorizeRequests().antMatchers("/rest/checkout/*").authenticated()
//			.and()
//		.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN")
			.and()
			.authorizeRequests().anyRequest().permitAll()
			.and()
			.formLogin()
			.defaultSuccessUrl("/main/")
			.failureUrl("/main/#/login")
			.and()
		.logout()
			.invalidateHttpSession(true)
			.logoutUrl("/logout")
			.logoutSuccessUrl("/main/")
			.permitAll();
		}

}
