package com.uploader.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.uploader.data.Author;
import com.uploader.dto.BookDto;
import com.uploader.services.BookUploaderServices;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("no-auth")
class BookUploaderControllerTest {

	@MockBean
	private BookUploaderServices bookUploadService;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void uploadNewBookTest() {
        MockMultipartFile firstFile = new MockMultipartFile("book", "filename.txt", "text/plain", "some xml".getBytes());
		Author author = new Author("John", "Doe", "john.doe@mail.ru");
		BookDto bookDto = new BookDto("some title", "desc", "en-US", "Sci-Fi", "pdf", "2020-12-10", author.getEmail(), "sdd23421");
		Mockito.when(bookUploadService.uploadBook(Mockito.any(BookDto.class), Mockito.eq(firstFile)))
			.thenReturn(Optional.of(bookDto));
		
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.multipart("/books")
					.file(firstFile)
					.param("title", bookDto.getTitle())
					.param("shortDescription", "asdf")
					.param("publishedDate", bookDto.getPublishedDate())
					.param("language", bookDto.getLanguage())
					.param("genre", bookDto.getGenre())
					.param("email", "hell")
					)
			.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void uploadExistingBookTest() {
		MockMultipartFile firstFile = new MockMultipartFile("book", "filename.txt", "text/plain", "some xml".getBytes());
		Author author = new Author("John", "Doe", "john.doe@mail.ru");
		BookDto bookDto = new BookDto("some title", "desc", "en-US", "Sci-Fi", "pdf", "2020-12-10", author.getEmail(), "sdd23421");
		
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.multipart("/books")
					.file(firstFile)
					.param("title", bookDto.getTitle())
					.param("shortDescription", "asdf")
					.param("publishedDate", bookDto.getPublishedDate())
					.param("language", bookDto.getLanguage())
					.param("genre", bookDto.getGenre())
					.param("email", "hell")
					)
			.andExpect(status().is(409));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
