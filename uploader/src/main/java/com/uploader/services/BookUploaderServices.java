package com.uploader.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.IObjectService;
import com.service.helpers.MultipartFileOM;

@Service
public class BookUploaderServices {

	private Logger log = LoggerFactory.getLogger(BookUploaderServices.class);
	@Autowired
	private Environment env;
	@Autowired
	private IObjectService s3Service;

	public boolean uploadBook(String email, String booktitle, String publisheddate, MultipartFile bookFile) {
		MultipartFileOM file = new MultipartFileOM(bookFile);
		
		System.out.println(env.getProperty("s3.accessSecret") + "   " +  env.getProperty("s3.accessKey"));
		
		String path = calculatePath(email.toLowerCase(), booktitle.toLowerCase(), file.getOriginalFileName());
		try {
			s3Service.uploadObject(path, file);
		} catch (Exception e) {
			log.error(e.fillInStackTrace().toString());
			return false;
		}
		
		return true;
	}

	/**
	 * A unique path to a book will be created from author email + booktitle + filename.extension
	 */
	private String calculatePath(String email, String booktitle, String originalFileName) {
		String validBookTitle = booktitle.replace(" ", "_");
		return email + "/" + validBookTitle + originalFileName;
	}	
	
}
