package com.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.service.IObjectService;
import com.service.S3Service;

@Configuration
public class S3Config {

	@Autowired
	private Environment env;
	
	@Bean
	public IObjectService getObjectService() {
		return new S3Service(env.getProperty("s3.accessSecret"), env.getProperty("s3.accessKey"));
	}
}