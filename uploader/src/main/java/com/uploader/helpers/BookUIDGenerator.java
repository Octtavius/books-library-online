package com.uploader.helpers;

import java.sql.Timestamp;

public class BookUIDGenerator {

	public static String generateBookId(String authorEmail) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + authorEmail;
	}
}
