package com.uploader.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksUploaderController {

	
	@PostMapping("/books")
	public String uploadBook(@RequestPart String email, @RequestPart String booktitle, @RequestPart String publisheddate) {
		
		System.out.println("hello " + email);
		return "successfull";
	}
}
