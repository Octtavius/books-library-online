package com.uploader.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfigs {

	@Bean
    @Profile("no-auth")
    WebSecurityConfigurerAdapter noAuth() {
        return new WebSecurityConfigurerAdapter() {
            @Override
			protected void configure(HttpSecurity http) throws Exception {
                http
                .csrf().disable()
                	.authorizeRequests()
                .anyRequest().permitAll();
            }
        };
    }
	@Bean
	@Profile("default")
	WebSecurityConfigurerAdapter defaultConfig() {
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/hello-all").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and().logout().permitAll()
				.and().httpBasic();
			}
		};
	}
}
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfigs extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private Environment env;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/hello-all").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll()
//		.and()
//		.httpBasic();
//	}
//}
