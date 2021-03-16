package com.uploader.configs;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@Configuration
public class WebSecurityConfigs extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;
	
	 @Bean
	  public UserDetailsService userDetailsService() {
	    UserDetailsService userDetailsService = 
	        new InMemoryUserDetailsManager();
	        
	    return userDetailsService;
	  }
	 
	@Bean
	public InitializingBean initializer(UserDetailsManager manager) {
		return () -> {
			UserDetails johnDoe = 
					User
						.withUsername("john.doe@mail.com")
						.password(passwordEncoder().encode(env.getProperty("testUserPassword")))
						.authorities("author")
						.build();
			
			manager.createUser(johnDoe);
		};
	}
	
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/hello-all").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll()
				.and()
				.httpBasic();
	}
}
