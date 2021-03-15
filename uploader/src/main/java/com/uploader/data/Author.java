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
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorseq")
	@SequenceGenerator(name="authorseq",  sequenceName = "authorseq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	
	public Author() {}
	
	public Author(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
}
