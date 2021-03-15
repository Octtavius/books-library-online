package com.uploader.helpers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeHelper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	public static String getCurrentTimeStampFormatted() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        return timestamp.toString();
	}
}
