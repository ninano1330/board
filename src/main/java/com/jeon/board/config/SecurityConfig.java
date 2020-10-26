package com.jeon.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import com.jeon.board.sample.config.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
      //.mvcMatchers("/", "/login", "/signUp","/user","h2-console").permitAll()
      .mvcMatchers("/*","h2-console").permitAll()
      .anyRequest().authenticated();

      http.formLogin().loginPage("/login/form.do").permitAll();

      http.logout().logoutSuccessUrl("/main");
//		super.configure(http);
	}
		
}
