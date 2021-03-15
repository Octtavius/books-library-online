package com.uploader.dto;

import org.springframework.web.multipart.MultipartFile;

public class BookDto {
	
	private Long id;
	private String title;
	private String shortDescription;
	private String language;
	private String genre;
	private String format;
	private String publishedDate;
	private String uploadedDate;
	private String documentUrl;
	private String authorEmail;
	private String uuid;
	
	private MultipartFile book;

	public BookDto(String title, String shortDescription, String language, String genre, String format,
			String publishedDate, String authorEmail, String uuid) {
		
		this.title = title;
		this.shortDescription = shortDescription;
		this.language = language;
		this.genre = genre;
		this.format = format;
		this.publishedDate = publishedDate;
		this.authorEmail = authorEmail;
		this.uuid = uuid;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public MultipartFile getBook() {
		return book;
	}


	public void setBook(MultipartFile book) {
		this.book = book;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public String getPublishedDate() {
		return publishedDate;
	}


	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}


	public String getUploadedDate() {
		return uploadedDate;
	}


	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}


	public String getDocumentUrl() {
		return documentUrl;
	}


	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}


	public String getAuthorEmail() {
		return authorEmail;
	}


	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	
	
}
