package com.uploader.controllers;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploader.services.BookUploaderServices;

@SpringBootApplication(scanBasePackages = "com.morcov")
@RestController
public class BooksUploaderController {

	@Autowired
	private BookUploaderServices bookUploadService;
	
	@PostMapping("/books")
	public String uploadBook(@RequestPart String email, @RequestPart String booktitle, @RequestPart String publisheddate, @RequestPart MultipartFile bookFile) {
		
		try {
			String bookContent = IOUtils.toString(bookFile.getBytes(), "UTF-8");
			System.out.println("book content: \n" + bookContent);
			
			bookUploadService.uploadBook(email, booktitle, publisheddate, bookFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "successfull";
	}
	
//	@GetMapping("/say")
//	public String hello() {
//		
//		
//		return "successfull";
//	}
}
