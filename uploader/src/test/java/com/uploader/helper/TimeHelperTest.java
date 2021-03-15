package com.uploader.helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uploader.helpers.TimeHelper;

class TimeHelperTest {

	private TimeHelper helper;
	
	@BeforeEach
	void setUp() throws Exception {
		helper = new TimeHelper();
	}

	@AfterEach
	void tearDown() throws Exception {
		helper = new TimeHelper();
	}

	@Test
	void test() {
		String timeFormatted = helper.getCurrentTimeStampFormatted();

		assertNotNull(timeFormatted);
	}

}
