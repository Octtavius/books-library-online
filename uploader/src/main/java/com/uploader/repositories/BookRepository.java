package com.uploader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uploader.data.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	//TODO add query for this method
	@Query("")
	Book getBookByTitleAndAuthorId(String title, String authorEmail);

}
