package com.uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com")
public class LibraryBookUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBookUploaderApplication.class, args);
	}

}
