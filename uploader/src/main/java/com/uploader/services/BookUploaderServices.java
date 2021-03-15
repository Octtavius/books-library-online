package com.uploader.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.IObjectService;
import com.service.helpers.MultipartFileOM;
import com.uploader.data.Author;
import com.uploader.data.Book;
import com.uploader.dto.BookDto;
import com.uploader.helpers.TimeHelper;
import com.uploader.repositories.AuthorRepository;
import com.uploader.repositories.BookRepository;

@Service
public class BookUploaderServices {

	private Logger log = LoggerFactory.getLogger(BookUploaderServices.class);
		
	@Autowired
	private IObjectService s3Service;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public boolean uploadBook(BookDto bookDto, MultipartFile bookFile) {
		MultipartFileOM file = new MultipartFileOM(bookFile);
		
		String path = calculatePath(bookDto.getAuthorEmail().toLowerCase(), bookDto.getTitle().toLowerCase(), file.getOriginalFileName());
		
		Author author = authorRepository.getAuthorByEmail(bookDto.getAuthorEmail());
		
		if (author == null) {
			return false;
		}
		
		
		
		Book book = new Book(bookDto.getTitle(), bookDto.getShortDescription(), bookDto.getLanguage(), bookDto.getGenre(), bookDto.getFormat(), bookDto.getPublishedDate(), TimeHelper.getCurrentTimeStampFormatted(), path, author.getId(), bookDto.getUuid());
		bookRepository.save(book);
		
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
