package com.uploader.controllers;

import java.io.IOException;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploader.dto.BookDto;
import com.uploader.helpers.BookUIDGenerator;
import com.uploader.services.BookUploaderServices;

@SpringBootApplication(scanBasePackages = "com.morcov")
@RestController
public class BooksUploaderController {

	@Autowired
	private BookUploaderServices bookUploadService;
	
	@PostMapping("/books")
	public ResponseEntity<BookDto> uploadBook(
			@RequestPart("book") MultipartFile book,
			@RequestParam String email, 
			@RequestParam String title, 
			@RequestParam String shortDescription,
			@RequestParam String publishedDate, 
			@RequestParam String language, 
			@RequestParam String genre
			) {
		
		BookDto bookDto = new BookDto(title, shortDescription, language, genre, "text/plain", publishedDate, email, BookUIDGenerator.generateBookId(email));
				
		try {
			String bookContent = IOUtils.toString(book.getBytes(), "UTF-8");
			System.out.println("book content: \n" + bookContent);
			
		Optional<BookDto> bookResposne = bookUploadService.uploadBook(bookDto, book);
		
		System.out.println(bookResposne.isEmpty());
		System.out.println(bookResposne.isPresent());
		
		if (bookResposne.isPresent()) {			
			return new ResponseEntity<>(
					bookResposne.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);			
		}
			
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
	@GetMapping("/say")
	public String hello() {
		
		return "successfull";
	}
}
