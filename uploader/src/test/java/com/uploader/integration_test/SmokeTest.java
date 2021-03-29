package com.uploader.integration_test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uploader.controllers.BooksUploaderController;

@SpringBootTest
class SmokeTest {

	@Autowired
	private BooksUploaderController bookUploadController;
	
	@Test
	void contextLoad() {
		assertThat(bookUploadController)
			.isNotNull();
	}

}
