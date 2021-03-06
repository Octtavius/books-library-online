package com.uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class LibraryBookUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBookUploaderApplication.class, args);
	}

}
