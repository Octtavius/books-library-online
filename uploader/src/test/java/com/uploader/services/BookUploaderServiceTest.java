package com.uploader.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.multipart.MultipartFile;

import com.service.IObjectService;
import com.uploader.data.Author;
import com.uploader.data.Book;
import com.uploader.dto.BookDto;
import com.uploader.repositories.AuthorRepository;
import com.uploader.repositories.BookRepository;

@SpringBootTest
class BookUploaderServiceTest {

	@MockBean
	BookRepository bookRepo;
	@MockBean
	AuthorRepository authorRepo;

	@MockBean
	private IObjectService s3Service;

	
	@Autowired
	private BookUploaderServices uploader;
	
	@Test
	@DisplayName("Test uploadBook")
	void uploadNewBookTest() {
		Author author = new Author("John", "Doe", "john.doe@mail.ru");
		BookDto bookDto = new BookDto("some title", "desc", "en-US", "Sci-Fi", "pdf", "2020-12-10", author.getEmail(), "sdd23421");
		MultipartFile file = mock(MultipartFile.class);
		
		when(authorRepo.getAuthorByEmail(bookDto.getAuthorEmail()))
			.thenReturn(author);
		
		Optional<BookDto> response = uploader.uploadBook(bookDto, file);
		
		assertThat(response.get()).isNotNull();
	}
	
	@Test
	void uploadExistingBookTest() {
		Author author = new Author("John", "Doe", "john.doe@mail.ru");
		BookDto bookDto = new BookDto("some title", "desc", "en-US", "Sci-Fi", "pdf", "2020-12-10", author.getEmail(), "sdd23421");
		
		Book book = new Book();
		MultipartFile file = mock(MultipartFile.class);
		
		when(authorRepo.getAuthorByEmail(bookDto.getAuthorEmail()))
		.thenReturn(author);
		when(bookRepo.getBookByTitleAndAuthorId(bookDto.getTitle(), bookDto.getAuthorEmail()))
			.thenReturn(book);
		
		Optional<BookDto> response = uploader.uploadBook(bookDto, file);
		
		assertThat(response.isEmpty()).isTrue();
	}

}
