package com.uploader.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="bookseq", sequenceName = "bookseq", initialValue = 1, allocationSize = 1)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookseq")
	private Long id;
	
	@Column
	private String title;
	@Column
	private String shortDescription;
	@Column
	private String language;
	@Column
	private String genre;
	@Column
	private String format;
	@Column
	private String publishedDate;
	@Column
	private String uploadedDate;
	@Column
	private String documentUrl;
	@Column
	private Long authorId;
	
	@Column(name = "uuid")
	private String bookUuid;
	
	public Book() {}

	public Book(String title, String shortDescription, String language, String genre, String format,
			String publishedDate, String uploadedDate, String documentUrl, Long authorId, String bookUuid) {
		
		this.title = title;
		this.shortDescription = shortDescription;
		this.language = language;
		this.genre = genre;
		this.format = format;
		this.publishedDate = publishedDate;
		this.uploadedDate = uploadedDate;
		this.documentUrl = documentUrl;
		this.authorId = authorId;
		this.bookUuid = bookUuid;
	}

	public String getBookUuid() {
		return bookUuid;
	}

	public void setBookUuid(String bookUuid) {
		this.bookUuid = bookUuid;
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

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getId() {
		return id;
	}
	
	

}
