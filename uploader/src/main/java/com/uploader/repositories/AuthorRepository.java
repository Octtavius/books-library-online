package com.uploader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uploader.data.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	@Query("Select a from Author a where a.email = :email")
	public Author getAuthorByEmail(String email);

}
